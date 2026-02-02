package com.pm.reservation.dto;

import jakarta.validation.constraints.NotBlank;

public class ReservationRequest {

    @NotBlank
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
