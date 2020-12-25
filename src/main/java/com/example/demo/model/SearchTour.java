package com.example.demo.model;

import java.util.Date;

public class SearchTour {
    private String name;
    private String startPlace;
    private String endPlace;
    private String province;
    private String national;
    private Date startTime;
    private Date endTime;
    private String time;

    public SearchTour() {
    }

    public SearchTour(String name, String startPlace, String endPlace, String province, String national, Date startTime, Date endTime, String time) {
        this.name = name;
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.province = province;
        this.national = national;
        this.startTime = startTime;
        this.endTime = endTime;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
