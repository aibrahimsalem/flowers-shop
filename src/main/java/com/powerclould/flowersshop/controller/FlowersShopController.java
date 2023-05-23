package com.powerclould.flowersshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.powerclould.flowersshop.model.Customer;
import com.powerclould.flowersshop.model.Flower;
import com.powerclould.flowersshop.model.FlowersWrapper;
import com.powerclould.flowersshop.repository.CustomerRepository;
import com.powerclould.flowersshop.repository.FlowerRepository;
import com.powerclould.flowersshop.repository.FlowersWrapperRepository;

@Controller
@RequestMapping(path = "/flowersshop")
public class FlowersShopController {

    @Autowired
    private FlowerRepository flowerRepository;

    @Autowired
    private FlowersWrapperRepository flowersWrapperRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path = "/flowers/add")
    public @ResponseBody String addFreshFlower(@RequestParam String name, @RequestParam String type,
            @RequestParam float price, @RequestParam int quantity) {
        Flower flower = new Flower();

        flower.setName(name);
        flower.setPrice(price);
        flower.setType(type);
        flower.setQuantity(quantity);

        flowerRepository.save(flower);

        return "Added a new flower";
    }

    @PostMapping(path = "/wrappers/add")
    public @ResponseBody String addFlowersWrapper(@RequestParam String color, @RequestParam int quantity,
            @RequestParam float price, @RequestParam String name, @RequestParam String material) {
        FlowersWrapper flowersWrapper = new FlowersWrapper(color, quantity, price, name, material);

        flowersWrapperRepository.save(flowersWrapper);

        return "Added a new flowers wrapper";
    }

    @PostMapping(path = "/customers/add")
    public @ResponseBody String addNewCustomer(@RequestParam String name, @RequestParam String phone,
            @RequestParam String email, @RequestParam String address) {
        Customer customer = new Customer(name, phone, email, address);

        customerRepository.save(customer);

        return "Added a new customer";
    }
}
