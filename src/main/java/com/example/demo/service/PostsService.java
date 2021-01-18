package com.example.demo.service;

import com.example.demo.model.PostRequest;
import com.example.demo.model.entity.ImageEntity;
import com.example.demo.model.entity.PostsEntity;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.PostsRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import java.util.*;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EntityManager entityManager;

    // get all
    public ResponseEntity<?> getAll() {
        try {
            List<PostsEntity> postsEntities = postsRepository.findAll();
            return ResponseEntity.ok().body(postsEntities);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get by id
    public ResponseEntity<?> getById(long id) {
        try {
            Optional<PostsEntity> postsEntity = postsRepository.findById(id);
            return ResponseEntity.ok().body(postsEntity);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // create
    public ResponseEntity<?> create(PostRequest postRequest, long idUser) {
            PostsEntity postsEntity=new PostsEntity();
        try {
            List<ImageEntity> imageEntityList = new ArrayList<>();
            for (int i = 0; i < postRequest.getImageEntities().size(); i++) {
                imageEntityList.add(new ImageEntity(postRequest.getImageEntities().get(i).getImage()));
                imageRepository.saveAndFlush(imageEntityList.get(i));
            }

            UserEntity userEntity = entityManager.getReference(UserEntity.class, idUser);
            postsEntity.setUserEntity(userEntity);
            postsEntity.setContent(postRequest.getContent());

            postsEntity.setImageEntities(imageEntityList);
            postsEntity.setTime(postRequest.getTime());
            postsEntity.setCommentEntities(null);
            postsEntity.setNameUser(userEntity.getName());
            postsEntity = postsRepository.saveAndFlush(postsEntity);
            for (ImageEntity i:imageEntityList) {
                i.setPostsEntity(postsEntity);
                imageRepository.saveAndFlush(i);
            }
            return ResponseEntity.ok().body(postsEntity);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update
    public ResponseEntity<?> update() {
        return null;
    }

    // delete
    public ResponseEntity<?> delete(long id) {

        Optional<PostsEntity> postsEntity = postsRepository.findById(id);
        if (!postsEntity.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        PostsEntity postsEntity1 = entityManager.getReference(PostsEntity.class, id);
        try {
            postsRepository.deleteById(postsEntity1.getId());
            postsRepository.deleteById(id);
            throw new ResponseStatusException(HttpStatus.OK, "THÀNH CÔNG");
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // like
    public void like(long idUser, long idPost) {

        try {
            Optional<PostsEntity> postsEntityOptional = postsRepository.findById(idPost);
            if (!postsEntityOptional.isPresent())
                return;
            Optional<UserEntity> userEntityOptional = userRepository.findById(idUser);
            if (!userEntityOptional.isPresent())
                return;
            if (!userEntityOptional.get().getLikePosts().contains(postsEntityOptional)) {
                postsEntityOptional.get().addLike(userEntityOptional.get());
                userEntityOptional.get().addLikePosts(postsEntityOptional.get());
            } else {
                postsEntityOptional.get().disLike(userEntityOptional.get());
                userEntityOptional.get().disLikePosts(postsEntityOptional.get());
            }
            postsRepository.save(postsEntityOptional.get());
            userRepository.save(userEntityOptional.get());

        } catch (Exception e) {
            return;
        }
    }
}
