package com.gzbook.service.like;

import com.gzbook.model.like.LikePost;
import com.gzbook.repository.LikePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikePostService implements ILikePostService{
    @Autowired
    private LikePostRepository likePostRepository;
    @Override
    public int create(LikePost like) {
        if (likePostRepository.findByPostIdAndUserId(like.getUserId(),like.getUserId()) == null) {
            likePostRepository.save(like);
            return 1;
        }
        return 0;
    }

    @Override
    public void delete(long likeId) {
        likePostRepository.deleteById(likeId);
    }

    @Override
    public LikePost checkLike(long postId, long userId) {
       return likePostRepository.findByPostIdAndUserId(postId, userId).orElse(null);
    }

    @Override
    public List<LikePost> likePost(long postId) {
        return (List<LikePost>) likePostRepository.findAllByPostId(postId);
    }
}
