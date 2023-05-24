package com.powerclould.flowersshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.powerclould.flowersshop.model.Customer;
import com.powerclould.flowersshop.repository.CustomerRepository;

@Component
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

    public String addNewCustomer(String name, String phone, String email, String address) {
        Customer customer = new Customer(name, phone, email, address);

        customerRepository.save(customer);

        return "Created new customer";
    }
}
