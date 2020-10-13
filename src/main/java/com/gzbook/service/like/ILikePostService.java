package com.gzbook.service.like;

import com.gzbook.model.like.LikePost;

import java.util.List;

public interface ILikePostService {
    int create(LikePost like);
    void delete(long likeId);
    LikePost checkLike(long postId, long userId);
    List likePost(long postId);
}
