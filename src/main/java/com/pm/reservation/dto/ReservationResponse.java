package com.pm.reservation.dto;

public class ReservationResponse {

    private Long id;
    private String customerName;

    public ReservationResponse(Long id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }
}
