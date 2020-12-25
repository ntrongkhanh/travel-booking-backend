package com.example.demo.service;

import com.example.demo.model.entity.ImageEntity;
import com.example.demo.model.entity.PostsEntity;
import com.example.demo.model.entity.TourEntity;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.PostsRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
    public ResponseEntity<Map<String, Object>> getAll(){
        try {
            List<PostsEntity> postsEntities = postsRepository.findAll();
            Map<String, Object> response = new HashMap<>();
            response.put("data", postsEntities);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // get by id
    public ResponseEntity<Map<String, Object>> getById(long id){
        try {
            Optional<PostsEntity> postsEntity=postsRepository.findById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("data", postsEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // create
    public ResponseEntity<Map<String, Object>> create(PostsEntity postsEntity,int idUser){

        try {
            List<ImageEntity> imageEntityList=new ArrayList<>();
            for (int i=0;i<postsEntity.getImageEntities().size();i++){
                imageEntityList.add(new ImageEntity(postsEntity.getImageEntities().get(i).getImage())) ;
                imageRepository.saveAndFlush(imageEntityList.get(i));
            }
            UserEntity userEntity=entityManager.getReference(UserEntity.class,idUser);
            postsEntity.setUserEntity(userEntity);
            postsEntity.setImageEntities(imageEntityList);
            postsEntity.setCommentEntities(null);

            postsEntity=postsRepository.save(postsEntity);
            Map<String, Object> response = new HashMap<>();
            response.put("data", postsEntity);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // update
    public ResponseEntity<Map<String, Object>> update(){
        return null;
    }
    // delete
    public ResponseEntity<Map<String, Object>> delete(long id){

        Optional<PostsEntity> postsEntity = postsRepository.findById(id);
        if (!postsEntity.isPresent())
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        PostsEntity postsEntity1 = entityManager.getReference(PostsEntity.class, id);
        try {
            postsRepository.deleteById(postsEntity1.getId());
            postsRepository.deleteById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("data", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // like
    public void like(long idUser,long idPost){

        try {
            Optional<PostsEntity> postsEntityOptional = postsRepository.findById(idPost);
            if (!postsEntityOptional.isPresent())
                return;
            Optional<UserEntity> userEntityOptional = userRepository.findById(idUser);
            if (!userEntityOptional.isPresent())
                return ;
            if (!userEntityOptional.get().getLikePosts().contains(postsEntityOptional))
            {
                postsEntityOptional.get().addLike(userEntityOptional.get());
                userEntityOptional.get().addLikePosts(postsEntityOptional.get());
            }else {
                postsEntityOptional.get().disLike(userEntityOptional.get());
                userEntityOptional.get().disLikePosts(postsEntityOptional.get());
            }
            postsRepository.save(postsEntityOptional.get());
            userRepository.save(userEntityOptional.get());
            Map<String, Object> response = new HashMap<>();
        } catch (Exception e) {
           return;
        }
    }
}
