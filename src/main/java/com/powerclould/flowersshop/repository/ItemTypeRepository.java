package com.powerclould.flowersshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.powerclould.flowersshop.model.ItemType;

public interface ItemTypeRepository extends CrudRepository<ItemType, Integer>{
    
}
