package com.training.flowersshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.flowersshop.model.FlowersOrder;
import com.training.flowersshop.model.Item;
import com.training.flowersshop.model.OrderItem;
import com.training.flowersshop.repository.FlowersOrderRepository;
import com.training.flowersshop.repository.ItemRepository;
import com.training.flowersshop.repository.OrderItemRepository;

@Component
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private FlowersOrderRepository flowersOrderRepository;

    @Autowired
    private ItemRepository itemRepository;

    public OrderItem addOrUpdateOrderItem(Integer id, int quantity, int flowersOrderId, int itemId) {
        Optional<OrderItem> OrderItemOptional = orderItemRepository.findById(id);
        OrderItem orderItem = null;
        
        if (OrderItemOptional.isPresent()) {
            orderItem = OrderItemOptional.get();
        } else {
            orderItem = new OrderItem();
            
        }
        Optional<FlowersOrder> flowersOrderOptional = flowersOrderRepository.findById(flowersOrderId);
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        setFlowersOrder(flowersOrderOptional, orderItem);
        setItem(itemOptional, orderItem);

        return orderItemRepository.save(orderItem);
    }

    private void setFlowersOrder(Optional<FlowersOrder> flowersOrderOptional, OrderItem orderItem) {
        flowersOrderOptional.ifPresent(flowersOrder -> orderItem.setFlowersOrder(flowersOrder));

    }

    private void setItem(Optional<Item> itemOptional, OrderItem orderItem) {
        itemOptional.ifPresent(item -> orderItem.setItem(item));

    }

    public Iterable<OrderItem> listAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public void deleteOrderItemById(int OrderItemId) {
        orderItemRepository.deleteById(OrderItemId);
    }
    
}
