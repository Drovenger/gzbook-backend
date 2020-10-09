package com.gzbook.service.post;

import com.gzbook.model.post.Post;

public interface IPostService {
    Post findPostById(Long id);

    Post savePost(Post post);

    void deletePost(Long id);

    Iterable<Post> findAllPost();

    Iterable<Post> findPostByUserId(Long userId);

    Iterable<Post> findByUserIdAndTextPostContains(Long id, String textPost);
}
