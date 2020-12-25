package com.example.demo.controller.user;

import com.example.demo.model.entity.PostsEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user/favorite")
public class FavoriteController {
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return null;
    }
    @GetMapping("/like")
    public ResponseEntity<Map<String, Object>> like() {
        return null;
    }
}
