package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class PostsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    private int amount_like;
    private int amount_comment;
    private Date time;
    private String nameUser;
    @JsonIgnore
    @OneToMany(mappedBy = "postsEntity")
    private List<CommentEntity> commentEntities;
    @OneToMany(mappedBy = "postsEntity")
    private List<ImageEntity> imageEntities ;
    // user id N 1
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    private UserEntity userEntity;

    @JsonIgnore
    @ManyToMany(mappedBy = "likePosts", cascade = {CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<UserEntity> userEntities;

    public PostsEntity() {
    }

    public PostsEntity(long id, String content, int amount_like, int amount_comment, Date time, List<CommentEntity> commentEntities, List<ImageEntity> imageEntities, UserEntity userEntity, List<UserEntity> userEntities) {
        this.id = id;
        this.content = content;
        this.amount_like = amount_like;
        this.amount_comment = amount_comment;
        this.time = time;
        this.commentEntities = commentEntities;
        this.imageEntities = imageEntities;
        this.userEntity = userEntity;
        this.userEntities = userEntities;
    }

    public PostsEntity(long id, String content, int amount_like, int amount_comment, Date time, String nameUser, List<CommentEntity> commentEntities, List<ImageEntity> imageEntities, UserEntity userEntity, List<UserEntity> userEntities) {
        this.id = id;
        this.content = content;
        this.amount_like = amount_like;
        this.amount_comment = amount_comment;
        this.time = time;
        this.nameUser = nameUser;
        this.commentEntities = commentEntities;
        this.imageEntities = imageEntities;
        this.userEntity = userEntity;
        this.userEntities = userEntities;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAmount_like() {
        return amount_like;
    }

    public void setAmount_like(int amount_like) {
        this.amount_like = amount_like;
    }

    public int getAmount_comment() {
        return amount_comment;
    }

    public void setAmount_comment(int amount_comment) {
        this.amount_comment = amount_comment;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public List<CommentEntity> getCommentEntities() {
        return commentEntities;
    }

    public void setCommentEntities(List<CommentEntity> commentEntities) {
        this.commentEntities = commentEntities;
    }

    public List<ImageEntity> getImageEntities() {
        return imageEntities;
    }

    public void setImageEntities(List<ImageEntity> imageEntities) {
        this.imageEntities = imageEntities;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
    public void addLike(UserEntity userEntity){
        this.userEntities.add(userEntity);
        this.amount_like++;
    }
    public void disLike(UserEntity userEntity){
        this.userEntities.remove(userEntity);
        this.amount_like--;
    }

}
