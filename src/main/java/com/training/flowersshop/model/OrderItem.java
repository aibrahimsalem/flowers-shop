package com.training.flowersshop.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "flowers_order_id", nullable = false)
    private FlowersOrder flowersOrder;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "quantity")
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FlowersOrder getFlowersOrder() {
        return flowersOrder;
    }

    public void setFlowersOrder(FlowersOrder flowersOrderId) {
        this.flowersOrder = flowersOrderId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public OrderItem() {
    }

}
