package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "image", columnDefinition = "TEXT")
    private String image;
    // tour id N 1
    @JsonIgnore
//    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "tour_id", nullable = true)
    private TourEntity tourEntity;
    // bài viết id N 1
    @JsonIgnore
//    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "posts_id", nullable = true)
    private PostsEntity postsEntity;

    public ImageEntity() {
    }

    public ImageEntity(String image) {
        this.image = image;
    }

    public ImageEntity(long id, String image, TourEntity tourEntity, PostsEntity postsEntity) {
        this.id = id;
        this.image = image;
        this.tourEntity = tourEntity;
        this.postsEntity = postsEntity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TourEntity getTourEntity() {
        return tourEntity;
    }

    public void setTourEntity(TourEntity tourEntity) {
        this.tourEntity = tourEntity;
    }

    public PostsEntity getPostsEntity() {
        return postsEntity;
    }

    public void setPostsEntity(PostsEntity postsEntity) {
        this.postsEntity = postsEntity;
    }
}
