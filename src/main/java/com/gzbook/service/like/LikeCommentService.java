package com.gzbook.service.like;

import com.gzbook.model.like.LikeComment;
import com.gzbook.repository.LikeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeCommentService implements ILikeCommentService{
    @Autowired
    private LikeCommentRepository likeCommentRepository;

    @Override
    public void create(LikeComment like) {
        likeCommentRepository.save(like);
    }

    @Override
    public void delete(LikeComment like) {
        likeCommentRepository.delete(like);
    }

    @Override
    public LikeComment checkLike(long commentId, long userId) {
        return likeCommentRepository.findByCommentIdAndUserId(commentId, userId).get();
    }

    @Override
    public int countLikeComment(long commentId) {
        return likeCommentRepository.countByCommentId(commentId);
    }
}
