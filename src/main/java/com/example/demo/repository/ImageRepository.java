package com.example.demo.repository;

import com.example.demo.model.entity.ImageEntity;
import com.example.demo.model.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity,Long> {
    public List<ImageEntity> findByTourEntity(long string);
}
