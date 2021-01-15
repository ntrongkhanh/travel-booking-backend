package com.example.demo.controller.user;

import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/tour")
public class UserTourController {
    @Autowired
    private TourService service;
    @Autowired
    private JwtUtils jwtUtils;
    @GetMapping("/like/")
    public void like(@RequestHeader("Authorization") String token, @RequestParam(value = "idTour") long idTour) {
        service.like(jwtUtils.getUserByJwtToken(token).getId(),idTour);
    }
    @GetMapping("/get-liked-tour/")
    public ResponseEntity<?> getLikedTour(@RequestHeader("Authorization") String token) {
        return service.getTourLiked(jwtUtils.getUserByJwtToken(token).getId());
    }
}
