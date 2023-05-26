package com.training.flowersshop.facade;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.flowersshop.model.FlowersOrder;
import com.training.flowersshop.service.FlowersOrderService;

@Component
public class FlowersOrderFacade {

    @Autowired
    private FlowersOrderService flowersOrderService;

    public FlowersOrder addOrUpdateFlowersOrder(int id, int customerId) {
        return flowersOrderService.addOrUpdateFlowersOrder(id, customerId);
    }

    public List<FlowersOrder> getAllFlowersOrder() {
        return StreamSupport.stream(flowersOrderService.getAllFlowersOrder().spliterator(), false).toList();
    }

    public void deleteFlowersOrderById(int flowersOrderId) {
        flowersOrderService.deleteFlowersOrderById(flowersOrderId);
    }

}
