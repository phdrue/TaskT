package com.example.taskt;

public class Order {
    public int id;
    public String address;
    public String client;
    public String product;
    public float price;

    public Order(int id, String address, String client, String product, float price) {
        this.id = id;
        this.address = address;
        this.client = client;
        this.product = product;
        this.price = price;
    }
}
