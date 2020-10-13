package com.gzbook.service.like;

import com.gzbook.model.like.LikePost;
import com.gzbook.repository.LikePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikePostService implements ILikePostService{
    @Autowired
    private LikePostRepository likePostRepository;
    @Override
    public void create(LikePost like) {
        likePostRepository.save(like);
    }

    @Override
    public void delete(LikePost like) {
        likePostRepository.delete(like);
    }

    @Override
    public LikePost checkLike(long postId, long userId) {
       return likePostRepository.findByPostIdAndUserId(postId, userId).get();
    }

    @Override
    public int countLikePost(long postId) {
        return likePostRepository.countByPostId(postId);
    }
}
