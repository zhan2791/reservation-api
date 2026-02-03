package com.pm.reservation.Service;

import com.pm.reservation.dto.ReservationRequest;
import com.pm.reservation.dto.ReservationResponse;

import java.util.List;

public interface ReservationService {
    ReservationResponse createReservation(ReservationRequest request);

    List<ReservationResponse> listReservations();
    ReservationResponse getReservation(Long id);
}
