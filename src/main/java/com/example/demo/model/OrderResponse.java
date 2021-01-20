package com.example.demo.model;

public class OrderResponse {
    private long id;
    private long total_price;
    private String tourName;
    private int amount;
    private long price;
    private String urlImage;
    private ContactRequest contactRequest;

    public OrderResponse() {
    }

    public OrderResponse(long id, long total_price, String tourName, int amount, long price, String urlImage, ContactRequest contactRequest) {
        this.id = id;
        this.total_price = total_price;
        this.tourName = tourName;
        this.amount = amount;
        this.price = price;
        this.urlImage = urlImage;
        this.contactRequest = contactRequest;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(long total_price) {
        this.total_price = total_price;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public ContactRequest getContactRequest() {
        return contactRequest;
    }

    public void setContactRequest(ContactRequest contactRequest) {
        this.contactRequest = contactRequest;
    }
}
