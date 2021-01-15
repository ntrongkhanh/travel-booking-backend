package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    private Date time;

    // user id 1 1
    @JsonIgnore
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    private UserEntity userEntity;
    // id bài viết N 1
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "posts_id", nullable = true)
    private PostsEntity postsEntity;

    public CommentEntity() {
    }

    public CommentEntity(long id, String content, Date time, UserEntity userEntity, PostsEntity postsEntity) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.userEntity = userEntity;
        this.postsEntity = postsEntity;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public PostsEntity getPostsEntity() {
        return postsEntity;
    }

    public void setPostsEntity(PostsEntity postsEntity) {
        this.postsEntity = postsEntity;
    }
}
