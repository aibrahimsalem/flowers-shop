package com.training.flowersshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.flowersshop.model.ItemType;
import com.training.flowersshop.repository.ItemTypeRepository;

@Component
public class ItemTypeService {

    @Autowired
    private ItemTypeRepository itemTypeRepository;

    public ItemType addOrUpdateItemType(int id, String name) {
        Optional<ItemType> itemTypeOptional = itemTypeRepository.findById(id);
        ItemType itemType = null;
        if (itemTypeOptional.isPresent()) {
            itemType = itemTypeOptional.get();

        } else {
            itemType = new ItemType();
        }

        itemType.setName(name);

        return itemTypeRepository.save(itemType);
    }

    public Iterable<ItemType> listAllItemTypes() {
        return itemTypeRepository.findAll();
    }

    public void deleteItemTypeById(int itemTypeId) {
        itemTypeRepository.deleteById(itemTypeId);
    }
    
}
