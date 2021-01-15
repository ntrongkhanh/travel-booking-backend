package com.example.demo.service;

import com.example.demo.model.entity.CommentEntity;
import com.example.demo.model.entity.PostsEntity;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.*;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private EntityManager entityManager;

    // get all
    public ResponseEntity<?> getAll(long id) {
        try {
            List<CommentEntity> list = commentRepository.findAllByPostsEntity(id);
            return ResponseEntity.ok().body(list);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //create
    public ResponseEntity<?> create(CommentEntity commentEntity) {
        try {
            PostsEntity postsEntity=entityManager.getReference(PostsEntity.class,commentEntity.getPostsEntity().getId());
            commentEntity.setPostsEntity(postsEntity);
            commentEntity = commentRepository.save(commentEntity);
            return ResponseEntity.ok().body(commentEntity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update
    public ResponseEntity<?> update(CommentEntity commentEntity) {
        try {
            Optional<CommentEntity> commentEntityOptional = commentRepository.findById(commentEntity.getId());
            if (!commentEntityOptional.isPresent())
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

//
//            List<UserEntity> list=repository.findByEmailAndPassword(userEntity.getEmail(),userEntity.getPassword());
//            if (list.size()==0)
//                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

            commentEntity = commentRepository.save(commentEntity);
            return ResponseEntity.ok().body(commentEntity);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // delete
    public void delete(long id) {
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
