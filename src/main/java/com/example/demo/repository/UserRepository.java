package com.example.demo.repository;

import com.example.demo.model.entity.UserEntity;
import com.example.demo.security.services.IUserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    public List<UserEntity> findByUsernameAndPassword(String username,String password);
//    @Query(value = "select id, username, password,name, token from user where username=:username",nativeQuery = true)
//    IUserDetailsImpl finUser(String username);
    Optional<UserEntity> findByUsername(String username);
    public  boolean existsByToken(String token);
}
