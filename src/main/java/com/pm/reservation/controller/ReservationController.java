package com.pm.reservation.controller;

import com.pm.reservation.Service.ReservationService;
import com.pm.reservation.dto.ReservationRequest;
import com.pm.reservation.dto.ReservationResponse;
import com.pm.reservation.util.ApiResponse;
import jakarta.validation.Valid;
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
    public ApiResponse<List<ReservationResponse>> list() {
        return ApiResponse.ok(reservationService.listReservations());
    }

    @GetMapping("/{id}")
    public ApiResponse<ReservationResponse> get(@PathVariable Long id) {
        return ApiResponse.ok(reservationService.getReservation(id));
    }
}
