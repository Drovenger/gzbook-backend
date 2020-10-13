package com.gzbook.service.like;

import com.gzbook.model.like.LikeComment;
import com.gzbook.model.like.LikePost;

import java.util.List;

public interface ILikeCommentService {
    int create(LikeComment like);
    LikeComment checkLike(long commentId, long userId);
    List likeComment(long commentId);
}
