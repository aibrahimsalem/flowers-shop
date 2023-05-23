package com.powerclould.flowersshop.model;

public class Bouquet {
    
    private int id;

    private String color;

    private int quantity;

    private float price;

    private String name;

    private String material;

    

    public Bouquet(String color, int quantity, float price, String name, String material) {
        this.color = color;
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    

}
