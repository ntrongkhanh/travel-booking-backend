package com.example.demo.model;

public class LoginResponse {
    private long id;
    private String name;
    private String username;
    private String phone;
    private String token;

    public LoginResponse() {
    }

    public LoginResponse(long id, String name, String username, String phone, String token) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.token = token;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
