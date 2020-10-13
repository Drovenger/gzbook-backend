package com.gzbook.service.like;

import com.gzbook.model.like.LikeComment;
import com.gzbook.repository.LikeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeCommentService implements ILikeCommentService{
    @Autowired
    private LikeCommentRepository likeCommentRepository;

    @Override
    public int create(LikeComment like) {
        LikeComment temp =
                likeCommentRepository.findByCommentIdAndUserId(like.getCommentId(), like.getUserId()).orElse(null);
        if (temp == null){
            likeCommentRepository.save(like);
            return 1;
        }else {
            likeCommentRepository.deleteById(temp.getId());
        }
        return -1;
    }

    @Override
    public LikeComment checkLike(long commentId, long userId) {
        return likeCommentRepository.findByCommentIdAndUserId(commentId, userId).orElse(null);
    }

    @Override
    public List<LikeComment> likeComment(long commentId) {
        return (List<LikeComment>) likeCommentRepository.findAllByCommentId(commentId);
    }
}
