package com.example.demo.security.services;

public interface IUserDetailsImpl {
    public long getId() ;

    public void setId(long id) ;

    public String getUsername() ;

    public void setUsername(String username) ;

    public String getPassword();

    public void setPassword(String password);

    public String getName();

    public void setName(String name);

    public String getToken();

    public void setToken(String token);
}
