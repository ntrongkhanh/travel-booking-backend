package com.example.demo.repository;

import com.example.demo.model.entity.ImageEntity;
import com.example.demo.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    public List<UserEntity> findByEmailAndPassword(String email,String password);
}
