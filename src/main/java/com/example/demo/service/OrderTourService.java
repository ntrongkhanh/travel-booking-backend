package com.example.demo.service;

import com.example.demo.model.ContactRequest;
import com.example.demo.model.OrderDetailRequest;
import com.example.demo.model.OrderResponse;
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
import java.util.*;

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
        System.out.printf("IDDD"+idUser);
        try {
            List<OrderTourEntity> orderTourEntities = orderTourRepository.findAllByUserEntityId(idUser);
            System.out.printf("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

            List<OrderResponse> list=new ArrayList<>();
            for (OrderTourEntity entity:orderTourEntities){
                OrderResponse orderResponse=new OrderResponse();

                int total=0;
                for(int i=0;i<entity.getOrderDetailEntities().size();i++){
                    total+=entity.getOrderDetailEntities().get(i).getAmount();
                }

                orderResponse.setAmount(total);
                orderResponse.setUrlImage(entity.getTourEntity().getAvatarTour());
                orderResponse.setTourName(entity.getTourEntity().getName());
                orderResponse.setTotal_price(entity.getTotal_price());
                orderResponse.setPrice(entity.getTourEntity().getPriceEntities().get(0).getPrice());
                orderResponse.setId(entity.getId());
                ContactRequest contactRequest=new ContactRequest();
                contactRequest.setPhone(entity.getContactEntity().getPhone());
                contactRequest.setName(entity.getContactEntity().getName());
                contactRequest.setIdCardNumber(entity.getContactEntity().getIdCardNumber());
                contactRequest.setEmail(entity.getContactEntity().getEmail());
                orderResponse.setContactRequest(contactRequest);
                orderResponse.setOrderDate(entity.getOrderDate());
                orderResponse.setDate(entity.getTourEntity().getStartTime());
                orderResponse.setPlace(entity.getTourEntity().getStartPlace());
                list.add(orderResponse);
            }


            return ResponseEntity.ok().body(list);
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
    public ResponseEntity<?> create(List<OrderDetailRequest> orderDetailRequests, ContactRequest contact, long idTour, long idUser) {

        long total = 0;
        for (int i = 0; i < orderDetailRequests.size(); i++) {
            total += (orderDetailRequests.get(i).getPrice() * orderDetailRequests.get(i).getAmount());
        }
        System.out.printf("0");
        OrderTourEntity orderTourEntity = new OrderTourEntity();

        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setEmail(contact.getEmail());
        contactEntity.setIdCardNumber(contact.getIdCardNumber());
        contactEntity.setPhone(contact.getPhone());
        contactEntity = contactRepository.saveAndFlush(contactEntity);
        orderTourEntity.setContactEntity(contactEntity);
        if (idUser != 0) {
            UserEntity userEntity = entityManager.getReference(UserEntity.class, idUser);
            orderTourEntity.setUserEntity(userEntity);
        }
        System.out.printf("aaaaaaaaa1");
        TourEntity tourEntity = entityManager.getReference(TourEntity.class, idTour);
        orderTourEntity.setTourEntity(tourEntity);
        orderTourEntity = orderTourRepository.saveAndFlush(orderTourEntity);
        orderTourEntity = entityManager.getReference(OrderTourEntity.class, orderTourEntity.getId());
        System.out.printf("aaaaaaaaa2");
        List<OrderDetailEntity> orderDetailList = new ArrayList<>();
        for (int i = 0; i < orderDetailRequests.size(); i++) {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setAmount(orderDetailRequests.get(i).getAmount());
            orderDetailEntity.setPrice(orderDetailRequests.get(i).getPrice());
            orderDetailEntity.setOrderTourEntity(orderTourEntity);

            orderDetailList.add(orderDetailEntity);

            //  orderDetailList.get(i).setOrderTourEntity(orderTourEntity);
        }
        System.out.printf("aaaaaaaaa3");
        orderDetailRepository.saveAll(orderDetailList);
        orderTourEntity = entityManager.getReference(OrderTourEntity.class, orderTourEntity.getId());
        orderTourEntity.setTotal_price(total);
        orderTourEntity.setOrderDate(new Date());
        System.out.printf("aaaaaaaaa4");
        orderTourEntity = orderTourRepository.save(orderTourEntity);
        System.out.printf("aaaaaaaaa5");
        throw new ResponseStatusException(HttpStatus.OK, "THÀNH CÔNG");
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
