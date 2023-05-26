package com.training.flowersshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.flowersshop.facade.FlowersOrderFacade;
import com.training.flowersshop.model.FlowersOrder;

@Controller
@RequestMapping(path = "/orders")
public class FlowersOrderController {

    @Autowired
    private FlowersOrderFacade flowersOrderFacade;

    @PostMapping(path = "/add")
    private @ResponseBody FlowersOrder addFlowersOrder(@RequestParam(required = false) Integer id,
            @RequestParam int customerId) {
                return flowersOrderFacade.addOrUpdateFlowersOrder(-1, customerId);
    }

    @GetMapping(path = "/all")
    private @ResponseBody List<FlowersOrder> getAllFlowersOrder() {
        return flowersOrderFacade.getAllFlowersOrder();
    }

    @GetMapping(path = "/delete/{flowersOrderId}")
    private @ResponseBody String deleteFlowersOrderById(@RequestParam int flowersOrderId) {
        flowersOrderFacade.deleteFlowersOrderById(flowersOrderId);
        return "Flowers Order "+ flowersOrderId + " deleted successfully";
    }

    @PostMapping(path = "/update")
    private @ResponseBody FlowersOrder updateFlowersOrder(@RequestParam(required = false) Integer id,
            @RequestParam int customerId) {
           return flowersOrderFacade.addOrUpdateFlowersOrder(id, customerId);     
    }

}
