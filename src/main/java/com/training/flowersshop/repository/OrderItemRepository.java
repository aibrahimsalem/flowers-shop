package com.training.flowersshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.flowersshop.model.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {
    
}
