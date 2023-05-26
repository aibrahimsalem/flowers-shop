package com.training.flowersshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.flowersshop.model.Customer;



public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findByEmail(String email);
}
