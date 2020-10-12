package com.gzbook.repository;

import com.gzbook.model.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Iterable<Post> findAllByUserId(Long id);
    Iterable<Post> findAllByStatus(int status);
    Iterable<Post> findAllByUserIdAndStatus(long id, int status);
}
