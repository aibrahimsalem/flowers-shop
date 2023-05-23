package com.powerclould.flowersshop.model;

public class OrderFlowerWrapper {
    
    private int id;

    private int orderId;

    private int flowerWrapperId;

    private int flowerId;

    

    public OrderFlowerWrapper(int id, int orderId, int flowerWrapperId, int flowerId) {
        this.id = id;
        this.orderId = orderId;
        this.flowerWrapperId = flowerWrapperId;
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

    public int getFlowerWrapperId() {
        return flowerWrapperId;
    }

    public void setFlowerWrapperId(int bouquetId) {
        this.flowerWrapperId = bouquetId;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    
}
