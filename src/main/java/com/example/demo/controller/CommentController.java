package com.example.demo.controller;

import com.example.demo.model.entity.CommentEntity;
import com.example.demo.model.entity.PostsEntity;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/public/comment")
public class CommentController {
    @Autowired
    private CommentService service;
    // xem tất cả các cmt
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getAllByPostsId(@PathVariable(value = "id") long id) {
        return service.getAll();
    }
}
