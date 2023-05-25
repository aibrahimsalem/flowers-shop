package com.training.flowersshop.facade;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.flowersshop.model.Customer;
import com.training.flowersshop.service.CustomerService;

@Component
public class CustomerFacade {

    @Autowired
    private CustomerService customerService;

    public Customer addOrUpdate(String name, String phone, String email, String address) {
        return customerService.addOrUpdateCustomer(name, phone, email, address);
    }

    public List<Customer> listAllCustomer() {

        return StreamSupport.stream(customerService.listAllCustomer().spliterator(), false)
                .collect(Collectors.toList());

    }

    public void deleteCustomerById(int customerId) {
        customerService.deleteCustomerById(customerId);
    }
}
