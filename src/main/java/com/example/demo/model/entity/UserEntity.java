package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "userEntity")
    private List<PostsEntity> postsEntities;
    @JsonIgnore
    @OneToMany(mappedBy = "userEntity")
    private List<CommentEntity> commentEntities;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "favorite", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tour_id"))
    private List<TourEntity> tourEntities;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(name = "like_post", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private List<PostsEntity> likePosts;

    public UserEntity() {
    }

    public UserEntity(long id, String name, String email, String phone, String password, List<PostsEntity> postsEntities, List<CommentEntity> commentEntities, List<TourEntity> tourEntities, List<PostsEntity> likePosts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.postsEntities = postsEntities;
        this.commentEntities = commentEntities;
        this.tourEntities = tourEntities;
        this.likePosts = likePosts;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PostsEntity> getPostsEntities() {
        return postsEntities;
    }

    public void setPostsEntities(List<PostsEntity> postsEntities) {
        this.postsEntities = postsEntities;
    }

    public List<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }

    public List<TourEntity> getTourEntities() {
        return tourEntities;
    }

    public void setTourEntities(List<TourEntity> tourEntities) {
        this.tourEntities = tourEntities;
    }

    public List<PostsEntity> getLikePosts() {
        return likePosts;
    }

    public void setLikePosts(List<PostsEntity> likePosts) {
        this.likePosts = likePosts;
    }
    public void addLikePosts(PostsEntity postsEntity){
        this.likePosts.add(postsEntity);
    }
    public void disLikePosts(PostsEntity postsEntity){
        this.likePosts.remove(postsEntity);
    }

}
