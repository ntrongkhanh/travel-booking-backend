package com.example.demo.repository;

import com.example.demo.model.entity.PriceEntity;
import com.example.demo.model.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity,Long> {
    public List<ScheduleEntity> findByTourEntity(long string);
}
