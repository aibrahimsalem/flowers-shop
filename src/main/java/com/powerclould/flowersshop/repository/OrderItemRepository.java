package com.powerclould.flowersshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.powerclould.flowersshop.model.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
    
}
