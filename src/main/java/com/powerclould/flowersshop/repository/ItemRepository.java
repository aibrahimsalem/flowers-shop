package com.powerclould.flowersshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.powerclould.flowersshop.model.Item;
import com.powerclould.flowersshop.model.ItemType;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    List<Item> findByItemType(ItemType itemType);
}
