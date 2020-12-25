package com.example.demo.repository;

import com.example.demo.model.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity,Long> {
  //  @Query(value = "select * from price  where tour_id=?1", nativeQuery = true)
 //   List<PriceEntity> findByTourId(long tourId);

    public List<PriceEntity> findByTourEntity(long string);
}
