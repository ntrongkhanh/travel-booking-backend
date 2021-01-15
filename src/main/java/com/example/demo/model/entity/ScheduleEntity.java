package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "schedule")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date time;
    @Column(name = "place", columnDefinition = "TEXT")
    private String place;
    // tour id N 1@JsonBackReference
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "tour_id", nullable = true)
    private TourEntity tourEntity;

    public ScheduleEntity() {
    }

    public ScheduleEntity(long id, Date time, String place, TourEntity tourEntity) {
        this.id = id;
        this.time = time;
        this.place = place;
        this.tourEntity = tourEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public TourEntity getTourEntity() {
        return tourEntity;
    }

    public void setTourEntity(TourEntity tourEntity) {
        this.tourEntity = tourEntity;
    }
}
