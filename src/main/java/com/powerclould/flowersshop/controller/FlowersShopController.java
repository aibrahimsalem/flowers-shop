package com.powerclould.flowersshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.powerclould.flowersshop.model.Flower;
import com.powerclould.flowersshop.repository.FlowerRepository;

@Controller
@RequestMapping(path = "/flowersshop")
public class FlowersShopController {
    
    @Autowired
    private FlowerRepository flowerRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addFreshFlower(@RequestParam String name, @RequestParam String type, @RequestParam float price, @RequestParam int quantity)
    {
        Flower flower = new Flower();

        flower.setName(name);
        flower.setPrice(price);
        flower.setType(type);
        flower.setQuantity(quantity);

        flowerRepository.save(flower);

        return "Added a new flower";
    }
}
