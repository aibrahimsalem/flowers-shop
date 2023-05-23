package com.powerclould.flowersshop.model;

public class OrderFlowerBouquet {
    
    private int id;

    private int orderId;

    private int bouquetId;

    private int flowerId;

    

    public OrderFlowerBouquet(int id, int orderId, int bouquetId, int flowerId) {
        this.id = id;
        this.orderId = orderId;
        this.bouquetId = bouquetId;
        this.flowerId = flowerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getBouquetId() {
        return bouquetId;
    }

    public void setBouquetId(int bouquetId) {
        this.bouquetId = bouquetId;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    
}
