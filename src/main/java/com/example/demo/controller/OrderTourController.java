package com.example.demo.controller;

import com.example.demo.model.entity.ContactEntity;
import com.example.demo.model.entity.OrderDetailEntity;
import com.example.demo.model.entity.OrderTourEntity;
import com.example.demo.model.entity.PostsEntity;
import com.example.demo.service.OrderTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/order")
public class OrderTourController {
    @Autowired
    private OrderTourService service;
    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id) {
        return service.getById(id);
    }
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<?> create(@Validated @RequestBody List<OrderDetailEntity> orderDetailList,
                                    @Validated @RequestBody ContactEntity contact,
                                    @Validated @RequestBody long idTour,@Validated @RequestBody long idUser) {
        return service.create(orderDetailList,contact,idTour,idUser);
    }

}
