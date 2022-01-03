package com.smari.server.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author smari
 */
public class CustomerModel {
    private Long id;
    private String firstName;
    private String lastName;
    private ShoppingCartModel cart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ShoppingCartModel getCart() {
        return cart;
    }

    public void setCart(ShoppingCartModel cart) {
        this.cart = cart;
    }
}
