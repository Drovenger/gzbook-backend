package com.gzbook.service.post;

import com.gzbook.model.post.Post;
import com.gzbook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post savePost(Post post) {
        postRepository.save(post);
        return post;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Iterable<Post> findAllPost() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
