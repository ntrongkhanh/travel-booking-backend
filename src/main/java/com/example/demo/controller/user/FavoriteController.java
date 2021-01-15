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
    public ResponseEntity<?> getAll(@RequestHeader("Authorization") String token) {

        return ResponseEntity.ok("a");
    }
    @GetMapping("/like/{id}")
    public ResponseEntity<?> like(@RequestHeader("Authorization") String token,@PathVariable(value = "id") long idTour) {
        return ResponseEntity.ok().body("a");
    }
}
