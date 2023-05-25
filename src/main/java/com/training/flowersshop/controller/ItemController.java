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

import com.training.flowersshop.facade.ItemFacade;
import com.training.flowersshop.model.Item;

@Controller
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private ItemFacade itemFacade;

    @PostMapping(path = "/add")
    private @ResponseBody Item addItem(@RequestParam(required = false) Integer id, @RequestParam String name,
            @RequestParam int quantity, @RequestParam String type, @RequestParam String color,
            @RequestParam float price, @RequestParam String material) {

        return itemFacade.addOrUpdateItem(-1, name, quantity, type, color, price, material);
    }

    @GetMapping(path = "/all")
    private @ResponseBody List<Item> listAllItems() {
        return itemFacade.listAllItems();
    }

    @GetMapping(path = "delete/{itemId}")
    private @ResponseBody String deleteItemById(@PathVariable int itemId) {
        itemFacade.deleteItemById(itemId);
        return "Item " + itemId + " has been deleted successfully";
    }

    @PostMapping(path = "/update")
    private @ResponseBody Item updateItem(@RequestParam int id, @RequestParam String name,
            @RequestParam int quantity, @RequestParam String type, @RequestParam String color,
            @RequestParam float price, @RequestParam String material) {
                
        return itemFacade.addOrUpdateItem(id, name, quantity, type, color, price, material);
    }
}
