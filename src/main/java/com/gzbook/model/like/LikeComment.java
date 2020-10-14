package com.gzbook.model.like;

import javax.persistence.*;

@Entity
@Table(name = "likecomment")
public class LikeComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long commentId;

    private Long userId;

    public LikeComment() {
    }

    public LikeComment(Long id, Long commentId, Long userId) {
        this.id = id;
        this.commentId = commentId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commenterId) {
        this.commentId = commenterId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long likerId) {
        this.userId = likerId;
    }
}
