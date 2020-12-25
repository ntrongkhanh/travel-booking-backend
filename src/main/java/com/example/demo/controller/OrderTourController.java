package com.example.demo.controller;

import com.example.demo.model.entity.OrderTourEntity;
import com.example.demo.model.entity.PostsEntity;
import com.example.demo.service.OrderTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/public/order")
public class OrderTourController {
    @Autowired
    private OrderTourService service;
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return service.getById(id);
    }
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody OrderTourEntity dto,@PathVariable(value = "id") long id) {
        return service.create(dto,id);
    }

}
