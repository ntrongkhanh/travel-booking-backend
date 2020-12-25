package com.example.demo.service;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.UserRepository;
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
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private EntityManager entityManager;
    // get by id
    public ResponseEntity<Map<String, Object>> getById(long id){
        Optional<UserEntity> user=repository.findById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("data", user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // create
    public ResponseEntity<Map<String, Object>> create(UserEntity userEntity){
        try {
            userEntity=repository.save(userEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", userEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // update
    public ResponseEntity<Map<String, Object>> update(UserEntity userEntity){
        try {
            Optional<UserEntity> userEntityOptional = repository.findById(userEntity.getId());
            if (!userEntityOptional.isPresent())
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

//
//            List<UserEntity> list=repository.findByEmailAndPassword(userEntity.getEmail(),userEntity.getPassword());
//            if (list.size()==0)
//                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            userEntity.setPassword(userEntity.getPassword());
            userEntity=repository.save(userEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", userEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Map<String, Object>> login(UserEntity userEntity){
        try {
            List<UserEntity> list = repository.findByEmailAndPassword(userEntity.getEmail(), userEntity.getPassword());
            if (list.size() == 0)
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            list.get(0).setPassword("");
            Map<String, Object> response = new HashMap<>();
            response.put("data", list.get(0));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
