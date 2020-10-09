package com.gzbook.controller;

import com.gzbook.model.post.Post;
import com.gzbook.model.user.User;
import com.gzbook.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    private IPostService postService;

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) throws ParseException {
        Date date = new SimpleDateFormat("dd.MM.yyyy HH:mm").parse(timeConvert());
        post.setCreatedTime(date);
        return new ResponseEntity<>(postService.savePost(post), HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.findPostById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deletePost(@RequestBody Post post, @PathVariable Long id) {
        postService.savePost(post);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    private String timeConvert() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return myDateObj.format(myFormatObj);
    }

    @GetMapping("findPostByPosterId/{posterId}")
    public ResponseEntity<Iterable<Post>> findPostByUserId(@PathVariable Long posterId) {
        return new ResponseEntity<>(postService.findPostByUserId(posterId), HttpStatus.OK);
    }

    @GetMapping("/searchPost/{posterId}/{textPost}")
    public ResponseEntity<Iterable<Post>> searchPostByTextPost(@PathVariable Long posterId, @PathVariable String textPost) {
        return new ResponseEntity<>(postService.findByUserIdAndTextPostContains(posterId,textPost), HttpStatus.OK);
    }

    @GetMapping("findImageByPosterId/{posterId}")
    public ResponseEntity<Iterable<String>> findImageByUserId(@PathVariable Long posterId) {
        List<String> images = new ArrayList<>();
        Iterable<Post> posts = postService.findPostByUserId(posterId);
        for (Post post: posts) {
            if (!post.getImageUrl().isEmpty() && post.getImageUrl() != null) {
                images.add(post.getImageUrl());
            }
        }
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/getPostLimited/{fromIndex}")
    public ResponseEntity<Iterable<Post>> findPostLimited(@PathVariable int fromIndex) {
        Iterable<Post> allPost = postService.findAllPost();
        List<Post> postList = new ArrayList<>();
        allPost.forEach(postList::add);
        List<Post> limitedPost = new ArrayList<>();
        for (int i = fromIndex; i < fromIndex + 5 && i < postList.size() ; i++) {
            limitedPost.add(postList.get(i));
        }
        return new ResponseEntity<>( limitedPost, HttpStatus.OK);
    }

}
