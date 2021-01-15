package com.example.demo.controller;

import com.example.demo.model.entity.CommentEntity;
import com.example.demo.model.entity.PostsEntity;
import com.example.demo.model.entity.TourEntity;
import com.example.demo.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/public/posts")
public class PostsController {
    @Autowired
    private PostsService service;

    // xem tất cả các post
    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return service.getAll();
    }
    // xem 1 post cụ thể
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") long id) {
        return service.getById(id);
    }
}
