package com.pm.reservation.Service;

import com.pm.reservation.dto.ReservationRequest;
import com.pm.reservation.dto.ReservationResponse;

public interface ReservationService {
    ReservationResponse createReservation(ReservationRequest request);
}
