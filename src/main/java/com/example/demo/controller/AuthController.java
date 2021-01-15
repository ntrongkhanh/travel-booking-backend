package com.example.demo.controller;

import com.example.demo.model.LoginRequest;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody UserEntity userEntity) {
        return userService.create(userEntity);
    }
    @RequestMapping(value = "/login", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginRequest userEntity) {

        return userService.login(userEntity);
    }
    @GetMapping("logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token)
    {
        return userService.logout(jwtUtils.getUserByJwtToken(token));
    }
}
