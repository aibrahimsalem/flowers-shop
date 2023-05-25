package com.training.flowersshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.flowersshop.facade.OrderItemFacade;
import com.training.flowersshop.model.OrderItem;

@Controller
@RequestMapping(path = "/order/item")
public class OrderItemController {

    @Autowired
    private OrderItemFacade orderItemFacade;

    @PostMapping(path = "/add")
    private @ResponseBody OrderItem addOrderItem(@RequestParam(required = false) Integer id, @RequestParam int quantity,
            @RequestParam int flowersOrderId, @RequestParam int itemId) {

        return orderItemFacade.addOrUpdateOrderItem(-1, quantity, flowersOrderId, itemId);
    }

    @GetMapping(path = "/all")
    private @ResponseBody List<OrderItem> listAllOrderItemss() {
        return orderItemFacade.listAllOrderItems();
    }

    @GetMapping(path = "delete/{orderItemId}")
    private @ResponseBody String deleteItemById(@PathVariable int orderItemId) {
        orderItemFacade.deleteOrderItemById(orderItemId);
        return "Order item " + orderItemId + " has been deleted successfully";
    }

    @PostMapping(path = "/update")
    private @ResponseBody OrderItem updateOrderItem(@RequestParam int id, @RequestParam int quantity,
            @RequestParam int flowersOrderId, @RequestParam int itemId) {

        return orderItemFacade.addOrUpdateOrderItem(id, quantity, flowersOrderId, itemId);
    }

}
