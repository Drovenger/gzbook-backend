package com.gzbook.model.comment;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long postId;

    private String content;

    private String commentTime;

    private int edited;

    public Comment() {
    }

    public Comment(Long id, Long userId, Long postId, String content, String commentTime, int edited) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.content = content;
        this.commentTime = commentTime;
        this.edited = edited;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long commentId) {
        this.id = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long commenterId) {
        this.userId = commenterId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public int getEdited() {
        return edited;
    }

    public void setEdited(int edited) {
        this.edited = edited;
    }
}
