package com.gzbook.service.like;

import com.gzbook.model.like.LikeComment;
import com.gzbook.model.like.LikePost;

public interface ILikeCommentService {
    void create(LikeComment like);
    void delete(LikeComment like);
    LikeComment checkLike(long commentId, long userId);
    int countLikeComment(long commentId);
}
