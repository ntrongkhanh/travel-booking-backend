package com.example.demo.service;

import com.example.demo.model.entity.ContactEntity;
import com.example.demo.model.entity.OrderTourEntity;
import com.example.demo.model.entity.TourEntity;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.OrderTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderTourService {
    @Autowired
    private OrderTourRepository orderTourRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private EntityManager entityManager;
    // get all
    public ResponseEntity<Map<String, Object>> getAll(long idUser) {

        try {
            List<OrderTourEntity> orderTourEntities = orderTourRepository.findAll();
            Map<String, Object> response = new HashMap<>();
            response.put("data", orderTourEntities);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get by id
    public ResponseEntity<Map<String, Object>> getById(long id) {
        try {
            Optional<OrderTourEntity> orderTourEntity=orderTourRepository.findById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("data", orderTourEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // create
    public ResponseEntity<Map<String, Object>> create(OrderTourEntity orderTourEntity,long idTour) {
        try {
            ContactEntity contactEntity=orderTourEntity.getContactEntity();
            contactEntity=contactRepository.saveAndFlush(contactEntity);
            orderTourEntity.setContactEntity(contactEntity);
            orderTourEntity=orderTourRepository.saveAndFlush(orderTourEntity);
            


            orderTourEntity.set
            Map<String, Object> response = new HashMap<>();
            response.put("data", userEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update
    public ResponseEntity<Map<String, Object>> update() {
        return null;
    }

    // delete
    public ResponseEntity<Map<String, Object>> delete() {
        return null;
    }
}
