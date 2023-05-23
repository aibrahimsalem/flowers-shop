package com.powerclould.flowersshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.powerclould.flowersshop.model.FlowersOrder;

public interface FlowersOrderRepository extends CrudRepository<FlowersOrder, Integer> {
    
}
