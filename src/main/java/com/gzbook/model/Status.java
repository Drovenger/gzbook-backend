package com.gzbook.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "statuses")
public class Status {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @NotBlank
    @NotEmpty
    private String content;

    @NotNull
    @NotBlank
    @NotEmpty
    private Date time;

    @NotNull
    @NotBlank
    @NotEmpty
    private int like;

    public Status() {
    }

    public Status(Long id, User user, @NotNull @NotBlank @NotEmpty String content, @NotNull @NotBlank @NotEmpty Date time, @NotNull @NotBlank @NotEmpty int like) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.time = time;
        this.like = like;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
