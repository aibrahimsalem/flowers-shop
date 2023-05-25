package com.training.flowersshop.facade;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.flowersshop.model.Item;
import com.training.flowersshop.service.ItemService;

@Component
public class ItemFacade {

    @Autowired
    private ItemService itemService;

    public Item addOrUpdateItem(int id, String name, int quantity, String type, String color, float price,
            String material) {
        return itemService.addOrUpdateItem(id, name, quantity, type, color, price, material);
    }

    public List<Item> listAllItems() {
        return StreamSupport.stream(itemService.listAllItems().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteItemById(int itemId) {
        itemService.deleteItemById(itemId);
    }

}
