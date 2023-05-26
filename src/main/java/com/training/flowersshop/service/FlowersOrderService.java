package com.training.flowersshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.flowersshop.model.Customer;
import com.training.flowersshop.model.FlowersOrder;
import com.training.flowersshop.repository.CustomerRepository;
import com.training.flowersshop.repository.FlowersOrderRepository;

@Component
public class FlowersOrderService {

    @Autowired
    private FlowersOrderRepository flowersOrderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public FlowersOrder addOrUpdateFlowersOrder(int id, int customerId) {
        Optional<FlowersOrder> flowersOrderOptional = flowersOrderRepository.findById(id);
        FlowersOrder flowersOrder = null;
        if (flowersOrderOptional.isPresent()) {
            flowersOrder = flowersOrderOptional.get();
        } else {
            flowersOrder = new FlowersOrder();
        }

        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        setCustomer(flowersOrder, customerOptional);
        flowersOrderRepository.save(flowersOrder);
        return flowersOrder;
    }

    private void setCustomer(FlowersOrder flowersOrder, Optional<Customer> customerOptional) {
        customerOptional.ifPresent(customer -> flowersOrder.setCustomer(customer));
    }

    public Iterable<FlowersOrder> getAllFlowersOrder() {
        return flowersOrderRepository.findAll();
    }

    public void deleteFlowersOrderById(int flowersOrderId) {
        flowersOrderRepository.deleteById(flowersOrderId);
    }

}
