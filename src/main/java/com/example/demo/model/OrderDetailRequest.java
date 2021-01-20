package com.example.demo.model;

public class OrderDetailRequest {
    private int amount;
    private long price;

    public OrderDetailRequest() {
    }

    public OrderDetailRequest(int amount, long price) {
        this.amount = amount;
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
