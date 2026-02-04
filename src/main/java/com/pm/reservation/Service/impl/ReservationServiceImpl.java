package com.pm.reservation.Service.impl;

import com.pm.reservation.Service.ReservationService;
import com.pm.reservation.domain.Reservation;
import com.pm.reservation.dto.PageResponse;
import com.pm.reservation.dto.ReservationRequest;
import com.pm.reservation.dto.ReservationResponse;
import com.pm.reservation.exception.ResourceNotFoundException;
import com.pm.reservation.repository.ReservationRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ReservationResponse createReservation(ReservationRequest request){
        Reservation reservation = new Reservation();
        reservation.setCustomerName(request.getCustomerName());

        Reservation saved = reservationRepository.save(reservation);

        return new ReservationResponse(saved.getId(), saved.getCustomerName());
    }

    @Override
    public PageResponse<ReservationResponse> listReservations(Pageable pageable) {
        var page = reservationRepository.findAll(pageable);

        var items = page.getContent()
                .stream()
                .map(r -> new ReservationResponse(r.getId(), r.getCustomerName()))
                .toList();

        return new PageResponse<>(
                items,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }

    @Override
    public ReservationResponse getReservation(Long id) {
        var reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found: " + id));
        return new ReservationResponse(reservation.getId(), reservation.getCustomerName());
    }
}
