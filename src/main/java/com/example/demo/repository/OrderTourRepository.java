package com.example.demo.repository;

import com.example.demo.model.entity.OrderTourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderTourRepository extends JpaRepository<OrderTourEntity, Long> {
//    @Query(value = "select * from order_tour  where user_id=?1", nativeQuery = true)
//    public List<OrderTourEntity> findByUserEntity(long id);

    List<OrderTourEntity> findAllByUserEntityId(long id);
}
