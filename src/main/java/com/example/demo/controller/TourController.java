package com.example.demo.controller;

import com.example.demo.model.SearchTour;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/public/tour")
public class TourController {
    @Autowired
    private TourService service;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getAll() {
        return service.getTop();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> search(@RequestBody SearchTour dto) {
        return service.search(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable(value = "id") long id) {
        return service.getById(id);
    }
}
