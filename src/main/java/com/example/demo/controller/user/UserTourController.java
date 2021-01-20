package com.example.demo.controller.user;

import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.service.OrderTourService;
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
    private OrderTourService orderTourService;
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

    @GetMapping("/get-orders/")
    public ResponseEntity<?> getOrderTour(@RequestHeader("Authorization") String token) {
        System.out.printf("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        System.out.printf(jwtUtils.getUserByJwtToken(token).getId()+"");
        System.out.printf("cccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        return orderTourService.getAll(jwtUtils.getUserByJwtToken(token).getId());
    }
}
