package com.example.demo.controller;

import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/public/demo")
public class DemoController {
    @Autowired
    private CommentService service;
    // xem tất cả các cmt
    @GetMapping("/{")
    public ResponseEntity<?> getAllByPostsId() {

        return ResponseEntity.ok().body(new demo("tên"));
    }
}

class demo{
    private String name;

    public demo() {
    }

    public demo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}