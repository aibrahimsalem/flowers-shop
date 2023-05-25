package com.training.flowersshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.flowersshop.model.Item;
import com.training.flowersshop.repository.ItemRepository;

@Component
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item addOrUpdateItem(int id, String name, int quantity, String type, String color, float price,
            String material) {

        Optional<Item> itemOptional = itemRepository.findById(id);
        Item item = null;
        if (itemOptional.isPresent()) {
            item = itemOptional.get();

        } else {
            item = new Item();
        }

        item.setName(name);
        item.setQuantity(quantity);
        item.setType(type);
        item.setColor(color);
        item.setPrice(price);
        item.setMaterial(material);

        return itemRepository.save(item);
        
    }

    public Iterable<Item> listAllItems() {
        return itemRepository.findAll();
    }

    public void deleteItemById(int itemId) {
        itemRepository.deleteById(itemId);
    }

}
