package com.training.flowersshop.facade;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.training.flowersshop.model.ItemType;
import com.training.flowersshop.service.ItemTypeService;

@Component
public class ItemTypeFacade {

    @Autowired
    private ItemTypeService itemTypeService;

    public ItemType addOrUpdateItemType(int id, String name) {
        return itemTypeService.addOrUpdateItemType(id, name);
    }

    public List<ItemType> listAllItemTypes() {
        return StreamSupport.stream(itemTypeService.listAllItemTypes().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteItemTypeById(int itemTypeId) {
        itemTypeService.deleteItemTypeById(itemTypeId);
    }
    
}
