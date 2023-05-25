package com.training.flowersshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.flowersshop.model.Customer;
import com.training.flowersshop.repository.CustomerRepository;

@Component
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addOrUpdateCustomer(String name, String phone, String email, String address) {
        Customer customer = customerRepository.findByEmail(email);
        if (customer != null) {
            customer.setEmail(email);
            customer.setAddress(address);
            customer.setName(name);
            customer.setPhone(phone);
        } else {
            customer = new Customer(name, phone, email, address);
        }

        return customerRepository.save(customer);
    }

    public Iterable<Customer> listAllCustomer() {
        return customerRepository.findAll();
    }

    public void deleteCustomerById(int customerId) {
        customerRepository.deleteById(customerId);
    }
}
