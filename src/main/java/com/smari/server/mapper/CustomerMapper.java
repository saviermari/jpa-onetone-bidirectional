package com.smari.server.mapper;

import com.smari.server.dto.CustomerModel;
import com.smari.server.entity.Customer;

public class CustomerMapper {
    public static CustomerModel convertEntityToModel(Customer entity){
        CustomerModel customerModel = new CustomerModel();
        if(entity != null){
            if(entity.getId() != null) customerModel.setId(entity.getId());
            customerModel.setFirstName(entity.getFirstName());
            customerModel.setLastName(entity.getLastName());
            ///customerModel.setCart(ShoppingCartMapper.convertEntityToModel(entity.getCart()));
        }
        return customerModel;
    }

    public static Customer convertModelToEntity(CustomerModel model){
        Customer customer = new Customer();
        if(model != null){
            if(model.getId() != null) customer.setId(model.getId());
            customer.setFirstName(model.getFirstName());
            customer.setLastName(model.getLastName());
            customer.setCart(ShoppingCartMapper.convertModelToEntity(model.getCart()));
        }
        return customer;
    }
}
