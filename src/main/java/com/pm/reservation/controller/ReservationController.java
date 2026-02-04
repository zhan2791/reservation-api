package com.pm.reservation.controller;

import com.pm.reservation.Service.ReservationService;
import com.pm.reservation.dto.PageResponse;
import com.pm.reservation.dto.ReservationRequest;
import com.pm.reservation.dto.ReservationResponse;
import com.pm.reservation.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/health")
    public ApiResponse<String> health() {
        return ApiResponse.ok("OK");
    }

    @PostMapping
    public ApiResponse<ReservationResponse> create(
            @Valid @RequestBody ReservationRequest request) {

        ReservationResponse response =
                reservationService.createReservation(request);

        return ApiResponse.ok(response);
    }

    @GetMapping
    public ApiResponse<PageResponse<ReservationResponse>> list(@PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return ApiResponse.ok(reservationService.listReservations(pageable));
    }

    @GetMapping("/{id}")
    public ApiResponse<ReservationResponse> get(@PathVariable Long id) {
        return ApiResponse.ok(reservationService.getReservation(id));
    }
}
