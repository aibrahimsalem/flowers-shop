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

import com.training.flowersshop.facade.ItemTypeFacade;
import com.training.flowersshop.model.ItemType;

@Controller
@RequestMapping(path = "/itemType")
public class ItemTypeController {


    @Autowired
    private ItemTypeFacade itemTypeFacade;

    @PostMapping(path = "/add")
    private @ResponseBody ItemType addItemType(@RequestParam(required = false) Integer id, @RequestParam String name) {

        return itemTypeFacade.addOrUpdateItemType(-1, name);
    }

    @GetMapping(path = "/all")
    private @ResponseBody List<ItemType> listAllItemTypess() {
        return itemTypeFacade.listAllItemTypes();
    }

    @GetMapping(path = "delete/{itemTypeId}")
    private @ResponseBody String deleteItemById(@PathVariable int itemTypeId) {
        itemTypeFacade.deleteItemTypeById(itemTypeId);
        return "Item type " + itemTypeId + " has been deleted successfully";
    }

    @PostMapping(path = "/update")
    private @ResponseBody ItemType updateItemType(@RequestParam int id, @RequestParam String name) {

        return itemTypeFacade.addOrUpdateItemType(id, name);
    }

}
