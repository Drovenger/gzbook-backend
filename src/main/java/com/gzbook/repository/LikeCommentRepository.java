package com.gzbook.repository;

import com.gzbook.model.like.LikeComment;
import com.gzbook.model.like.LikePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {
    Iterable<LikeComment> findAllByCommentId(long commentId);
    Optional<LikeComment> findByCommentIdAndUserId(long commentId, long userId);
    int countByCommentId(long commentId);
}
