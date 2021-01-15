package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int amount;
    private long price;
    // order tour id N 1
    @JsonIgnore
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "order_tour_id", nullable = true)
    private OrderTourEntity orderTourEntity;

    // price id  N 1
    @JsonIgnore
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "price_id", nullable = true)
    private PriceEntity priceEntity;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(long id, int amount, long price, OrderTourEntity orderTourEntity,
                             PriceEntity priceEntity) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.orderTourEntity = orderTourEntity;
        this.priceEntity = priceEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public OrderTourEntity getOrderTourEntity() {
        return orderTourEntity;
    }

    public void setOrderTourEntity(OrderTourEntity orderTourEntity) {
        this.orderTourEntity = orderTourEntity;
    }

    public PriceEntity getPriceEntity() {
        return priceEntity;
    }

    public void setPriceEntity(PriceEntity priceEntity) {
        this.priceEntity = priceEntity;
    }
}
