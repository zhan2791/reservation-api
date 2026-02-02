package com.pm.reservation.Service.impl;

import com.pm.reservation.Service.ReservationService;
import com.pm.reservation.domain.Reservation;
import com.pm.reservation.dto.ReservationRequest;
import com.pm.reservation.dto.ReservationResponse;
import com.pm.reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

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
}
