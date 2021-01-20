package com.example.demo.repository;

import com.example.demo.model.entity.OrderTourEntity;
import com.example.demo.model.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<TourEntity, Long> {
//    @Query(value = "select * from category c where c.name like %:name% and c.is_laptop=1", nativeQuery = true)
//    public List<TourEntity> getByName(@Param("name") String name);
//
    @Query(value = "select * from tour t\n" +
            "where ( ?1 is null or t.name like %?1% )\n"
            + "and ( ?2 is null  or t.province like %?2%)\n"
            + "and ( ?3 is null or t.national like %?3%)\n"
            + "and ( ?4 is null or t.start_place like %?4%)\n"
            + "and ( ?5 is null or t.end_place like %?5%)\n"
            + "and ( ?6 is null or t.time like %?6%)\n"
//            //    +   "and (  ?5 =null or ?5= ''  or ?5='string' or t.start_time like %?5%)\n"
//            + "and ( ?6 is null or t.end_place like %?6%)\n"
//            //     +    "and ( ?7 =null or ?7= ''  or '?7='string' or t.end_time like %?7% )\n"
//            + "and ( ?8 is null or t.time like %?8%)"
            , nativeQuery = true)
    public List<TourEntity> search(String name, String province, String national, String startPlace, String endPlace, String time ,Date startTime, Date endTime);
//
    @Query(value = "select * from tour, favorite as f where f.user_id=?1 and f.tour_id=tour.id",nativeQuery = true)
    public List<TourEntity> getTourLike(long id);



    @Query(value = "select * from tour where f.user_id=?1 and f.tour_id=tour.id",nativeQuery = true)
    public List<TourEntity> getTourOrder(long id);
}
