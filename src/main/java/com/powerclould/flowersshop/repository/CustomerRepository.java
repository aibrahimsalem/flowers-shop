package com.powerclould.flowersshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.powerclould.flowersshop.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
    
}
