package com.example.demo.service;

import com.example.demo.model.SearchTour;
import com.example.demo.model.entity.TourEntity;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TourService {
    @Autowired
    private TourRepository repo;
    @Autowired
    private ScheduleRepository scheduleRepository;
    // get all
    // get top
    public ResponseEntity<Map<String, Object>> getTop(){
        try {
            List<TourEntity> tourEntities = repo.findAll();
            Map<String, Object> response = new HashMap<>();
            response.put("data", tourEntities);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // get by id
    public ResponseEntity<Map<String, Object>> getById(long id){
        try {
            Optional<TourEntity> tourEntity=repo.findById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("data", tourEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // search
    public ResponseEntity<Map<String, Object>> search(SearchTour dto){
        try {
            List<TourEntity> tourEntities = repo.search(dto.getName(),dto.getProvince(),dto.getNational(),dto.getStartPlace(),dto.getEndPlace(),dto.getTime(),dto.getStartTime(),dto.getEndTime());
            Map<String, Object> response = new HashMap<>();
            response.put("data", tourEntities);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
