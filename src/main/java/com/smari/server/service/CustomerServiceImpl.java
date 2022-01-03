package com.smari.server.service;

import com.smari.server.dao.CustomerRepository;
import com.smari.server.dao.ShoppingCartRepository;
import com.smari.server.dto.CustomerModel;
import com.smari.server.dto.ShoppingCartModel;
import com.smari.server.entity.Customer;
import com.smari.server.mapper.CustomerMapper;
import com.smari.server.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author smari
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private ShoppingCartRepository cartRepository;

    @Override
    @Transactional
    public CustomerModel createCustomer(CustomerModel model) {
        CustomerModel customerModel = saveCustomer(model);
        return customerModel;
    }

    @Override
    @Transactional
    public CustomerModel updateCustomer(CustomerModel model) {
        CustomerModel customerModel = saveCustomer(model);
        return customerModel;
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CustomerModel getCustomer(Long id) {
        Optional<Customer> entity = repository.findById(id);
        if (entity.isPresent()) {
            CustomerModel model =  CustomerMapper.convertEntityToModel(entity.get());
            ShoppingCartModel cartModel = ShoppingCartMapper.convertEntityToModel(cartRepository.getById(entity.get().getCart().getId()));
            model.setCart(cartModel);
            return model;
        }
        return null;
    }

    @Override
    public List<CustomerModel> getAllCustomers() {
        List<Customer> customers = repository.findAll();
        List<CustomerModel> customerModels = new ArrayList<>();
        for(Customer entity: customers){
            CustomerModel model = CustomerMapper.convertEntityToModel(entity);
            ShoppingCartModel cartModel = ShoppingCartMapper.convertEntityToModel(cartRepository.getById(entity.getCart().getId()));
            model.setCart(cartModel);
            customerModels.add(model);
        }
        return customerModels;
    }

    private CustomerModel saveCustomer(CustomerModel model) {
        Customer customer = CustomerMapper.convertModelToEntity(model);
        Customer entity = repository.save(customer);
        CustomerModel customerModel = CustomerMapper.convertEntityToModel(entity);
        ShoppingCartModel cartModel = ShoppingCartMapper.convertEntityToModel(cartRepository.getById(entity.getCart().getId()));
        customerModel.setCart(cartModel);
        return customerModel;
    }
}
