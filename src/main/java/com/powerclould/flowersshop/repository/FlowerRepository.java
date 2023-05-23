package com.powerclould.flowersshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.powerclould.flowersshop.model.Flower;

public interface FlowerRepository extends CrudRepository<Flower, Integer> {
    
}
