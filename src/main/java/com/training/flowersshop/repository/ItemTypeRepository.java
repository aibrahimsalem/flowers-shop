package com.training.flowersshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.flowersshop.model.ItemType;

public interface ItemTypeRepository extends CrudRepository<ItemType, Integer>{
    
}
