package com.gzbook.service.post;

import com.gzbook.model.post.Post;

public interface IPostService {
    Post findPostById(Long id);

    Post savePost(Post post);

    void deletePost(Long id);

    Iterable<Post> findAllPost();

    Iterable<Post> findAllByUserId(Long userId);

    Iterable<Post> findAllByStatus(long status);

    Iterable<Post> findAllByUserIdAndStatus(long id, int status);

    Iterable<Post> findAllByStatusIn(int status);
}
