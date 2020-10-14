package com.gzbook.service.post;

import com.gzbook.model.post.Post;
import com.gzbook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Iterable<Post> findAllByUserId(Long id) {
        return postRepository.findAllByUserId(id);
    }

    @Override
    public Iterable<Post> findAllByStatus(long status) {
        return postRepository.findAllByStatus(status);
    }

    @Override
    public Iterable<Post> findAllByStatusIn(long[] status){
        return postRepository.findAllByStatusIn(status);
    }

    @Override
    public List<Post> searchContent(long userId, String content) {
        List<Post> listPost = (List<Post>) postRepository.findAllByUserId(userId);
        List<Post> temp = new ArrayList<>();
        for (Post i : listPost){
            if (i.getTextPost().contains(content)){
                temp.add(i);
            }
        }
        return temp;
    }

    @Override
    public Iterable<Post> findAllByUserIdAndStatus(long id, int status) {
        return postRepository.findAllByUserIdAndStatus(id, status);
    }
}
