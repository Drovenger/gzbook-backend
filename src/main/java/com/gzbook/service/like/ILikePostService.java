package com.gzbook.service.like;

import com.gzbook.model.like.LikePost;

public interface ILikePostService {
    void create(LikePost like);
    void delete(LikePost like);
    LikePost checkLike(long postId, long userId);
    int countLikePost(long postId);
}
