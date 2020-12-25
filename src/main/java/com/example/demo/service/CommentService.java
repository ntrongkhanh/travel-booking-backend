package com.example.demo.service;

import com.example.demo.model.entity.CommentEntity;
import com.example.demo.model.entity.ImageEntity;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.*;

@Service
public class CommentService {
@Autowired
private CommentRepository commentRepository;
@Autowired
private EntityManager entityManager;
    // get all
    public ResponseEntity<Map<String, Object>> getAll(){
        return null;
    }
    //create
    public ResponseEntity<Map<String, Object>> create(CommentEntity commentEntity){
        try {
            commentEntity=commentRepository.save(commentEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", commentEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // update
    public ResponseEntity<Map<String, Object>> update(CommentEntity commentEntity){
        try {
            Optional<CommentEntity> commentEntityOptional = commentRepository.findById(commentEntity.getId());
            if (!commentEntityOptional.isPresent())
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

//
//            List<UserEntity> list=repository.findByEmailAndPassword(userEntity.getEmail(),userEntity.getPassword());
//            if (list.size()==0)
//                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

            commentEntity=commentRepository.save(commentEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", commentEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // delete
    public void delete(long id){
        Optional<CommentEntity> product = commentRepository.findById(id);
        if (!product.isPresent())
            return;
        CommentEntity commentEntity = entityManager.getReference(CommentEntity.class, id);
        try {
            commentRepository.deleteById(id);
        } catch (Exception e) {
            return;
        }

    }
}
