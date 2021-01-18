package com.example.demo.model;

import com.example.demo.model.entity.ImageEntity;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class PostRequest {
    private String content;
    private Date time;
    private List<ImageEntity> imageEntities ;

    public PostRequest() {
    }

    public PostRequest(String content, Date time, List<ImageEntity> imageEntities) {
        this.content = content;
        this.time = time;
        this.imageEntities = imageEntities;
    }

    public PostRequest(String content, List<ImageEntity> imageEntities) {
        this.content = content;
        this.imageEntities = imageEntities;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ImageEntity> getImageEntities() {
        return imageEntities;
    }

    public void setImageEntities(List<ImageEntity> imageEntities) {
        this.imageEntities = imageEntities;
    }
}
