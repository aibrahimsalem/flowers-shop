package com.powerclould.flowersshop.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.powerclould.flowersshop.service.CustomerService;

@Component
public class CustomerFacade {
    
    @Autowired
    private CustomerService customerService;

    public String addNewCustomer(String name, String phone, String email, String address) {
        return customerService.addNewCustomer(name, phone, email, address);
    }
}
