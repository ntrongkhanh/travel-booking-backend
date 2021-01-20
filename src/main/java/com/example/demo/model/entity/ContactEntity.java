package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name", columnDefinition = "TEXT")
    private String name;
    private String email;
    private String phone;
    private String idCardNumber;

//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private OrderTourEntity orderTourEntity;
    @JsonIgnore
    @OneToOne(mappedBy = "contactEntity")
    private OrderTourEntity orderTourEntity;

    public ContactEntity() {
    }

    public ContactEntity(long id, String name, String email, String phone, String idCardNumber, OrderTourEntity orderTourEntity) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.idCardNumber = idCardNumber;
        this.orderTourEntity = orderTourEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public OrderTourEntity getOrderTourEntity() {
        return orderTourEntity;
    }

    public void setOrderTourEntity(OrderTourEntity orderTourEntity) {
        this.orderTourEntity = orderTourEntity;
    }
}
