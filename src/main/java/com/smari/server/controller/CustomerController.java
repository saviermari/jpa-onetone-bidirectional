package com.smari.server.controller;

import com.smari.server.dto.CustomerModel;
import com.smari.server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author smari
 */
@RestController
@RequestMapping(value = "/rest/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CustomerController {
    @Autowired
    CustomerService service;

    @PostMapping("/customers")
    public CustomerModel Customer(@RequestBody CustomerModel model){
        return service.createCustomer(model);
    }

    @PutMapping("/customers/{id}")
    public CustomerModel updateCustomer(@RequestBody CustomerModel model, @PathVariable Long id){
        CustomerModel customer = service.getCustomer(id);
        if(customer == null){
            throw new RuntimeException("Not found");
        }
        if(model != null) if (null == model.getId()) {
            model.setId(customer.getId());
        }
        return service.updateCustomer(model);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        service.deleteCustomer(id);
    }

    @GetMapping("/customers/{id}")
    public CustomerModel getCustomer(@PathVariable Long id){
        return service.getCustomer(id);
    }

    @GetMapping("/customers")
    public List<CustomerModel> getAllCustomers(){
        return service.getAllCustomers();
    }
}
