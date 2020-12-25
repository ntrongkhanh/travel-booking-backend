package com.example.demo.controller.user;

import com.example.demo.model.entity.PostsEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user/posts")
public class UserPostsController {
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") long id) {
        return;
    }
    // tạo post
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> create(@Validated @RequestBody PostsEntity dto) {
        return null;
    }
    // sửa post
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@RequestBody PostsEntity dto)  {
        return null;
    }
    // like
    @GetMapping("/like")
    public ResponseEntity<Map<String, Object>> like() {
        return null;
    }
}
