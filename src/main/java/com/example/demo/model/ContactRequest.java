package com.example.demo.model;

import javax.persistence.Column;
import java.util.List;

public class ContactRequest {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String idCardNumber;
    private long idUser;
    private long idTour;
    private List<OrderDetailRequest> orderDetailRequests;

    public ContactRequest() {
    }

    public ContactRequest(long id, String name, String email, String phone, String idCardNumber, List<OrderDetailRequest> orderDetailRequests) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.idCardNumber = idCardNumber;
        this.orderDetailRequests = orderDetailRequests;
    }

    public long getIdTour() {
        return idTour;
    }

    public void setIdTour(long idTour) {
        this.idTour = idTour;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
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

    public List<OrderDetailRequest> getOrderDetailRequests() {
        return orderDetailRequests;
    }

    public void setOrderDetailRequests(List<OrderDetailRequest> orderDetailRequests) {
        this.orderDetailRequests = orderDetailRequests;
    }
}
