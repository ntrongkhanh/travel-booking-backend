package com.example.demo.repository;

import com.example.demo.model.entity.CommentEntity;
import com.example.demo.model.entity.OrderTourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {
    @Query(value = "select * from comment  where posts_id=?1", nativeQuery = true)
    public List<CommentEntity> findAllByPostsEntity(long id);
}
