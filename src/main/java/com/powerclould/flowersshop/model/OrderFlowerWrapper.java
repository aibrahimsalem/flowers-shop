package com.powerclould.flowersshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderFlowerWrapper {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    @ManyToOne
    @JoinColumn(name = "flowers_order_id", nullable = false)
    private FlowersOrder flowersOrderId;

    @ManyToOne
    @JoinColumn(name = "flowers_wrapper_id", nullable = false)
    private FlowersWrapper flowerWrapperId;

    @ManyToOne
    @JoinColumn(name = "flower_id", nullable = false)
    private Flower flower;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FlowersOrder getFlowersOrderId() {
        return flowersOrderId;
    }

    public void setFlowersOrderId(FlowersOrder flowersOrderId) {
        this.flowersOrderId = flowersOrderId;
    }

    public FlowersWrapper getFlowerWrapperId() {
        return flowerWrapperId;
    }

    public void setFlowerWrapperId(FlowersWrapper flowerWrapperId) {
        this.flowerWrapperId = flowerWrapperId;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    
}
