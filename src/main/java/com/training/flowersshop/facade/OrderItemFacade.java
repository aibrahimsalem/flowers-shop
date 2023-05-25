package com.training.flowersshop.facade;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.flowersshop.model.OrderItem;
import com.training.flowersshop.service.OrderItemService;

@Component
public class OrderItemFacade {

    @Autowired
    private OrderItemService orderItemService;

    public OrderItem addOrUpdateOrderItem(Integer id, int quantity, int flowersOrderId, int itemId) {
        return orderItemService.addOrUpdateOrderItem(id, quantity, flowersOrderId, itemId);
    }

    public List<OrderItem> listAllOrderItems() {
        return StreamSupport.stream(orderItemService.listAllOrderItems().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteOrderItemById(int orderItemId) {
        orderItemService.deleteOrderItemById(orderItemId);
    }
    
}
