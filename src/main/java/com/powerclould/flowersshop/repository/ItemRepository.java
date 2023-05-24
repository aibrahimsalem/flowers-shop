package com.powerclould.flowersshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.powerclould.flowersshop.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
