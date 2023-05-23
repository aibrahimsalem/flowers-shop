package com.powerclould.flowersshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class FlowersOrder {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    
    public FlowersOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int orderId) {
        this.id = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomerId(Customer customer) {
        this.customer = customer;
    }

    
}
