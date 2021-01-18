package com.example.demo.controller.user;

import com.example.demo.model.PostRequest;
import com.example.demo.model.entity.PostsEntity;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user/posts")
public class UserPostsController {
    @Autowired
    private PostsService postsService;
    @Autowired
    private JwtUtils jwtUtils;
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") long id) {
        return;
    }
    // tạo post
    @RequestMapping(value = "/create", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestHeader("Authorization") String token,@Validated @RequestBody PostRequest dto) {
        return postsService.create(dto,jwtUtils.getUserByJwtToken(token).getId());
    }
    // sửa post
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestHeader("Authorization") String token,@RequestBody PostsEntity dto)  {
        return ResponseEntity.ok("a");
    }
    // like
    @GetMapping("/like/{id}")
    public void like(@RequestHeader("Authorization") String token,@PathVariable("id") long idPost) {
         postsService.like(jwtUtils.getUserByJwtToken(token).getId(),idPost);
    }
}
