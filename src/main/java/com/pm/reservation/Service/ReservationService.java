package com.pm.reservation.Service;

import com.pm.reservation.dto.PageResponse;
import com.pm.reservation.dto.ReservationRequest;
import com.pm.reservation.dto.ReservationResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReservationService {
    ReservationResponse createReservation(ReservationRequest request);

    PageResponse<ReservationResponse> listReservations(Pageable pageable);
    ReservationResponse getReservation(Long id);
}
