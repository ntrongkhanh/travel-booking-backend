package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tour")
public class TourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name", columnDefinition = "TEXT")
    private String name;
    private String codeTour;
    @Column(name = "startPlace", columnDefinition = "TEXT")
    private String startPlace;
    @Column(name = "endPlace", columnDefinition = "TEXT")
    private String endPlace;
    @Column(name = "province", columnDefinition = "TEXT")
    private String province;
    @Column(name = "national", columnDefinition = "TEXT")
    private String national;
    private Date startTime;
    private Date endTime;
    private String time;
    private String status;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "avatarTour", columnDefinition = "TEXT")
    private String avatarTour;
    private int discountPercent;
    @JsonIgnore
    @OneToMany(mappedBy = "tourEntity")
    private List<OrderTourEntity> orderTourEntities;


    @OneToMany(mappedBy = "tourEntity")
    private List<PriceEntity> priceEntities;


    @OneToMany(mappedBy = "tourEntity")
    private List<ScheduleEntity> scheduleEntities;

    @OneToMany(mappedBy = "tourEntity")
    private List<ImageEntity> imageEntities;

    @JsonIgnore
    @ManyToMany(mappedBy = "tourEntities", cascade = {CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<UserEntity> userEntities;

    public TourEntity() {
    }

    public TourEntity(long id, String name, String codeTour, String startPlace, String endPlace, String province,
                      String national, Date startTime, Date endTime, String time, String description, String avatarTour,
                      int discountPercent, List<OrderTourEntity> orderTourEntities, List<PriceEntity> priceEntities,
                      List<ScheduleEntity> scheduleEntities, List<ImageEntity> imageEntities,
                      List<UserEntity> userEntities) {
        this.id = id;
        this.name = name;
        this.codeTour = codeTour;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.province = province;
        this.national = national;
        this.startTime = startTime;
        this.endTime = endTime;
        this.time = time;
        this.description = description;
        this.avatarTour = avatarTour;
        this.discountPercent = discountPercent;
        this.orderTourEntities = orderTourEntities;
        this.priceEntities = priceEntities;
        this.scheduleEntities = scheduleEntities;
        this.imageEntities = imageEntities;
        this.userEntities = userEntities;
    }

    public TourEntity(long id, String name, String codeTour, String startPlace, String endPlace, String province, String national, Date startTime, Date endTime, String time, String status, String description, String avatarTour, int discountPercent, List<OrderTourEntity> orderTourEntities, List<PriceEntity> priceEntities, List<ScheduleEntity> scheduleEntities, List<ImageEntity> imageEntities, List<UserEntity> userEntities) {
        this.id = id;
        this.name = name;
        this.codeTour = codeTour;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.province = province;
        this.national = national;
        this.startTime = startTime;
        this.endTime = endTime;
        this.time = time;
        this.status = status;
        this.description = description;
        this.avatarTour = avatarTour;
        this.discountPercent = discountPercent;
        this.orderTourEntities = orderTourEntities;
        this.priceEntities = priceEntities;
        this.scheduleEntities = scheduleEntities;
        this.imageEntities = imageEntities;
        this.userEntities = userEntities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeTour() {
        return codeTour;
    }

    public void setCodeTour(String codeTour) {
        this.codeTour = codeTour;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarTour() {
        return avatarTour;
    }

    public void setAvatarTour(String avatarTour) {
        this.avatarTour = avatarTour;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    @JsonIgnore
    public List<OrderTourEntity> getOrderTourEntities() {
        return orderTourEntities;
    }

    public void setOrderTourEntities(List<OrderTourEntity> orderTourEntities) {
        this.orderTourEntities = orderTourEntities;
    }

    public List<PriceEntity> getPriceEntities() {
        return priceEntities;
    }

    public void setPriceEntities(List<PriceEntity> priceEntities) {
        this.priceEntities = priceEntities;
    }

    public List<ScheduleEntity> getScheduleEntities() {
        return scheduleEntities;
    }

    public void setScheduleEntities(List<ScheduleEntity> scheduleEntities) {
        this.scheduleEntities = scheduleEntities;
    }

    public List<ImageEntity> getImageEntities() {
        return imageEntities;
    }

    public void setImageEntities(List<ImageEntity> imageEntities) {
        this.imageEntities = imageEntities;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public void addLike(UserEntity userEntity) {
        this.userEntities.add(userEntity);

    }

    public void disLike(UserEntity userEntity) {
        this.userEntities.remove(userEntity);
    }
}
