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
    @Column(name = "name", columnDefinition = "TEXT")
    private String name;
    private String username;
    private String phone;
    @JsonIgnore
    private String token;
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

    @JsonIgnore
    @OneToMany(mappedBy = "userEntity")
    private List<OrderTourEntity> orderTourEntities;


    public UserEntity() {
    }

    public UserEntity(long id, String name, String email, String phone, String token, String password, List<PostsEntity> postsEntities, List<CommentEntity> commentEntities, List<TourEntity> tourEntities, List<PostsEntity> likePosts, List<OrderTourEntity> orderTourEntities) {
        this.id = id;
        this.name = name;
        this.username = email;
        this.phone = phone;
        this.token = token;
        this.password = password;
        this.postsEntities = postsEntities;
        this.commentEntities = commentEntities;
        this.tourEntities = tourEntities;
        this.likePosts = likePosts;
        this.orderTourEntities = orderTourEntities;
    }

    public UserEntity(long id, String name, String email, String phone, String password, List<PostsEntity> postsEntities, List<CommentEntity> commentEntities, List<TourEntity> tourEntities, List<PostsEntity> likePosts) {
        this.id = id;
        this.name = name;
        this.username = email;
        this.phone = phone;
        this.password = password;
        this.postsEntities = postsEntities;
        this.commentEntities = commentEntities;
        this.tourEntities = tourEntities;
        this.likePosts = likePosts;
    }

    public UserEntity(long id, String name, String email, String phone, String password, List<PostsEntity> postsEntities, List<CommentEntity> commentEntities, List<TourEntity> tourEntities, List<PostsEntity> likePosts, List<OrderTourEntity> orderTourEntities) {
        this.id = id;
        this.name = name;
        this.username = email;
        this.phone = phone;
        this.password = password;
        this.postsEntities = postsEntities;
        this.commentEntities = commentEntities;
        this.tourEntities = tourEntities;
        this.likePosts = likePosts;
        this.orderTourEntities = orderTourEntities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<OrderTourEntity> getOrderTourEntities() {
        return orderTourEntities;
    }

    public void setOrderTourEntities(List<OrderTourEntity> orderTourEntities) {
        this.orderTourEntities = orderTourEntities;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void addLikeTour(TourEntity tourEntity){
        this.tourEntities.add(tourEntity);
    }
    public void disLikeTour(TourEntity tourEntity){
        this.tourEntities.remove(tourEntity);
    }

}
