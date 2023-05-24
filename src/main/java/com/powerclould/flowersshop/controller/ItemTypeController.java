package com.powerclould.flowersshop.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.powerclould.flowersshop.model.ItemType;
import com.powerclould.flowersshop.repository.ItemTypeRepository;

@Controller
@RequestMapping(path = "/itemType")
public class ItemTypeController {

    @Autowired
    private ItemTypeRepository itemTypeRepository;


    protected ItemType getItemType(int itemTypeId) {
        Optional<ItemType> itemType = itemTypeRepository.findById(itemTypeId);
        if (itemType.isPresent()) {
            return itemType.get();
        }

        return null;
    }

}
