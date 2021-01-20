package com.example.demo.service;

import com.example.demo.model.SearchTour;
import com.example.demo.model.entity.OrderTourEntity;
import com.example.demo.model.entity.PostsEntity;
import com.example.demo.model.entity.TourEntity;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.OrderTourRepository;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.repository.TourRepository;
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
public class TourService {
    @Autowired
    private TourRepository repo;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderTourRepository orderTourRepository;

    // get top
    public ResponseEntity<?> getTop() {
        try {
            List<TourEntity> tourEntities = repo.findAll();
            return ResponseEntity.ok().body(tourEntities);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get by id
    public ResponseEntity<?> getById(long id) {
        try {
            Optional<TourEntity> tourEntity = repo.findById(id);
            return ResponseEntity.ok().body(tourEntity);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // search
    public ResponseEntity<?> search(SearchTour dto) {
        try {
            List<TourEntity> tourEntities = repo.search(dto.getName(), dto.getProvince(), dto.getNational(), dto.getStartPlace(), dto.getEndPlace(), dto.getTime(), dto.getStartTime(), dto.getEndTime());
            return ResponseEntity.ok().body(tourEntities);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void like(long idUser, long idTour) {

        try {
            UserEntity userEntity = entityManager.getReference(UserEntity.class, idUser);
            TourEntity tourEntity = entityManager.getReference(TourEntity.class, idTour);

            Optional<UserEntity> optionalUserEntity = userRepository.findById(idUser);
            Optional<TourEntity> optionalTourEntity = repo.findById(idTour);
            if (!optionalUserEntity.isPresent())
                return;
            if (!optionalTourEntity.isPresent())
                return;


            if (!optionalUserEntity.get().getLikePosts().contains(optionalTourEntity)) {
                optionalTourEntity.get().addLike(optionalUserEntity.get());
                optionalUserEntity.get().addLikeTour(optionalTourEntity.get());
            } else {
                optionalTourEntity.get().disLike(optionalUserEntity.get());
                optionalUserEntity.get().disLikeTour(optionalTourEntity.get());
            }
            repo.save(optionalTourEntity.get());
            userRepository.save(optionalUserEntity.get());
        } catch (Exception e) {
            return;
        }
    }

    public void diskLike(long idUser, long idTour) {

        try {
            UserEntity userEntity = entityManager.getReference(UserEntity.class, idUser);
            TourEntity tourEntity = entityManager.getReference(TourEntity.class, idTour);

            Optional<UserEntity> optionalUserEntity = userRepository.findById(idUser);
            Optional<TourEntity> optionalTourEntity = repo.findById(idTour);
            if (!optionalUserEntity.isPresent())
                return;
            if (!optionalTourEntity.isPresent())
                return;

            optionalTourEntity.get().disLike(optionalUserEntity.get());
            optionalUserEntity.get().disLikeTour(optionalTourEntity.get());
            repo.save(optionalTourEntity.get());
            userRepository.save(optionalUserEntity.get());
        } catch (Exception e) {
            return;
        }
    }

    public ResponseEntity<?> getTourLiked(long id) {
        try {
            List<TourEntity> tourEntities = repo.getTourLike(id);
            return ResponseEntity.ok().body(tourEntities);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<?> getOder(long id) {
        try {
            System.out.printf("IDDDDDDDDDDDD: "+id);
            List<OrderTourEntity> tourEntities = orderTourRepository.findAllByUserEntityId(id);
            System.out.printf("22222222222222222: ");
            Map<String,String > re=new HashMap<>();
            re.put("lemg",tourEntities.size()+"");

            return ResponseEntity.ok().body(re);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
