package com.example.demo.service;

import com.example.demo.model.entity.*;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderTourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    // get all
    public ResponseEntity<?> getAll(long idUser) {

        try {
            List<OrderTourEntity> orderTourEntities = orderTourRepository.findByUserEntity(idUser);
            return ResponseEntity.ok().body(orderTourEntities);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get by id
    public ResponseEntity<?> getById(long id) {
        try {
            Optional<OrderTourEntity> orderTourEntity = orderTourRepository.findById(id);
            return ResponseEntity.ok().body(orderTourEntity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // create
    public ResponseEntity<?> create(List<OrderDetailEntity> orderDetailList, ContactEntity contact, long idTour, long idUser) {
        try {
            OrderTourEntity orderTourEntity = new OrderTourEntity();
            ContactEntity contactEntity = contact;
            contactEntity = contactRepository.saveAndFlush(contactEntity);
            orderTourEntity.setContactEntity(contactEntity);
            if (idUser != 0) {
                UserEntity userEntity = entityManager.getReference(UserEntity.class, idUser);
                orderTourEntity.setUserEntity(userEntity);
            }
            orderTourEntity = orderTourRepository.saveAndFlush(orderTourEntity);
            for (int i = 0; i < orderDetailList.size(); i++) {
                orderDetailList.get(i).setOrderTourEntity(orderTourEntity);
            }
            orderDetailRepository.saveAll(orderDetailList);
            throw new ResponseStatusException(HttpStatus.OK, "THÀNH CÔNG");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update
    public ResponseEntity<?> update() {
        return null;
    }

    // delete
    public ResponseEntity<?> delete() {
        return null;
    }
}
