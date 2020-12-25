package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "price")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    private long basePrice;
    private long Price;

    // tour id N 1
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "tour_id", nullable = true)
    private TourEntity tourEntity;

    @OneToMany(mappedBy = "priceEntity")
    private List<OrderDetailEntity> orderDetailEntities;

    public PriceEntity() {
    }

    public PriceEntity(long id, String type, long basePrice, long price, TourEntity tourEntity,
                       List<OrderDetailEntity> orderDetailEntities) {
        this.id = id;
        this.type = type;
        this.basePrice = basePrice;
        Price = price;
        this.tourEntity = tourEntity;
        this.orderDetailEntities = orderDetailEntities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(long basePrice) {
        this.basePrice = basePrice;
    }

    public long getPrice() {
        return Price;
    }

    public void setPrice(long price) {
        Price = price;
    }

    public TourEntity getTourEntity() {
        return tourEntity;
    }

    public void setTourEntity(TourEntity tourEntity) {
        this.tourEntity = tourEntity;
    }

    public List<OrderDetailEntity> getOrderDetailEntities() {
        return orderDetailEntities;
    }

    public void setOrderDetailEntities(List<OrderDetailEntity> orderDetailEntities) {
        this.orderDetailEntities = orderDetailEntities;
    }
}
