package com.training.flowersshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.flowersshop.model.FlowersOrder;

public interface FlowersOrderRepository extends CrudRepository<FlowersOrder, Integer> {
    
}
