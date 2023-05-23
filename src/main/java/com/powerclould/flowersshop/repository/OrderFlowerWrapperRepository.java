package com.powerclould.flowersshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.powerclould.flowersshop.model.OrderFlowerWrapper;

public interface OrderFlowerWrapperRepository extends CrudRepository<OrderFlowerWrapper, Integer> {
    
}
