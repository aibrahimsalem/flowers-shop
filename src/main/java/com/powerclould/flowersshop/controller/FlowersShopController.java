package com.powerclould.flowersshop.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(path = "/flowers/buy")
    public @ResponseBody String buyFlowers() throws NumberFormatException, IOException {
        System.out.println("Please choose the flowers from the available flowers separated by commas. ex: to choose flowers 1 and 2 write 1,2");
        System.out.println("########################################################");
        Iterable<Flower> allFlowersIterable = flowerRepository.findAll();
        allFlowersIterable.forEach(flower -> System.out.println("###ID###: " + flower.getId() + " ###Name###: " + flower.getName() + " ###Quantity###: " + flower.getQuantity() + " ###Price###: " + flower.getPrice() + " ###Type###: "+  flower.getType()));
        System.out.println("########################################################");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] flowers = bufferedReader.readLine().split(",");
        System.out.println("Please specify the quantity for each flower respectively. ex: if you choose flower 1 and 2 write 3,5");
        String[] quantites = bufferedReader.readLine().split(",");
        System.out.println("You chose " + quantites[0] + " from flower " + flowers[0]);
        System.out.println(
                "Please choose the flowers' wrapper from the available wrappers separated by commas. ex: to choose wrapper 1 and 2 write 1,2");
        System.out.println("########################################################");
        Iterable<FlowersWrapper> allFlowersWrapperIterable = flowersWrapperRepository.findAll();
        allFlowersWrapperIterable.forEach(flowerWrapper -> System.out.println("###ID###: " + flowerWrapper.getId() + " ###Name###: "
                + flowerWrapper.getName() + " ###Quantity###: " + flowerWrapper.getQuantity() + " ###Price###: " + flowerWrapper.getPrice()
                + " ###Material###: " + flowerWrapper.getMaterial() + " Color: " + flowerWrapper.getColor()));
        System.out.println("########################################################");
        String[] wrappers = bufferedReader.readLine().split(",");
        System.out.println("You chose " + wrappers[0] + " from flower " + flowers[0]);
        return "listed all flowers";
    }
}
