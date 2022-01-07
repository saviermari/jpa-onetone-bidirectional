package com.smari.server.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author smari
 */
public class ShoppingCartModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private double totalAmount;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private CustomerModel customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }
}
