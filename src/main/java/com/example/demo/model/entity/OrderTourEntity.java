package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_tour")
public class OrderTourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long total_price;
    private Date orderDate;
    @OneToMany(mappedBy = "orderTourEntity")
    private List<OrderDetailEntity> orderDetailEntities;

    // tour id N 1

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "tour_id", nullable = true)
    private TourEntity tourEntity;
    // contact id 1 1
//    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "contact_id", nullable = true)
//    private ContactEntity contactEntity;

    @JsonIgnore
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    private UserEntity userEntity;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private ContactEntity contactEntity;

    public OrderTourEntity() {
    }

    public OrderTourEntity(long id, long total_price, List<OrderDetailEntity> orderDetailEntities, TourEntity tourEntity, ContactEntity contactEntity) {
        this.id = id;
        this.total_price = total_price;
        this.orderDetailEntities = orderDetailEntities;
        this.tourEntity = tourEntity;
        this.contactEntity = contactEntity;
    }

    public OrderTourEntity(long id, long total_price, Date orderDate, List<OrderDetailEntity> orderDetailEntities, TourEntity tourEntity, UserEntity userEntity, ContactEntity contactEntity) {
        this.id = id;
        this.total_price = total_price;
        this.orderDate = orderDate;
        this.orderDetailEntities = orderDetailEntities;
        this.tourEntity = tourEntity;
        this.userEntity = userEntity;
        this.contactEntity = contactEntity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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

    public List<OrderDetailEntity> getOrderDetailEntities() {
        return orderDetailEntities;
    }

    public void setOrderDetailEntities(List<OrderDetailEntity> orderDetailEntities) {
        this.orderDetailEntities = orderDetailEntities;
    }

    public TourEntity getTourEntity() {
        return tourEntity;
    }

    public void setTourEntity(TourEntity tourEntity) {
        this.tourEntity = tourEntity;
    }

    public ContactEntity getContactEntity() {
        return contactEntity;
    }

    public void setContactEntity(ContactEntity contactEntity) {
        this.contactEntity = contactEntity;
    }
}
