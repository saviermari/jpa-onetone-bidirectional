package com.smari.server.service;

import com.smari.server.dto.CustomerModel;

import java.util.List;

/**
 * @author smari
 */
public interface CustomerService {
    public CustomerModel createCustomer(CustomerModel model);
    public CustomerModel updateCustomer(CustomerModel model);
    public void deleteCustomer(Long id);
    public CustomerModel getCustomer(Long id);
    public List<CustomerModel> getAllCustomers();
}
