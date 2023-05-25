package com.training.flowersshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.training.flowersshop.model.Item;
import com.training.flowersshop.model.ItemType;

public interface ItemRepository extends CrudRepository<Item, Integer> {

    List<Item> findByItemType(ItemType itemType);
}
