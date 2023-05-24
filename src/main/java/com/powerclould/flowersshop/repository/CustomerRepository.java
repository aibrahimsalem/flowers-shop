package com.powerclould.flowersshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.powerclould.flowersshop.model.Customer;
import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByEmail(String email);
}
