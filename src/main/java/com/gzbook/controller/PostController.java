package com.gzbook.controller;

import com.gzbook.model.post.Post;
import com.gzbook.model.user.User;
import com.gzbook.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
@RequestMapping(value = "/post")
public class PostController {
    @Autowired
    private IPostService postService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Post>> findAllPost() {
        return new ResponseEntity<>(postService.findAllPost(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) throws ParseException {
        post.setCreatedTime(timeConvert());
        return new ResponseEntity<>(postService.savePost(post), HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable Long id) {
        return new ResponseEntity<>(postService.findPostById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        postService.savePost(post);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("findPostByPosterId/{posterId}")
    public ResponseEntity<Iterable<Post>> findPostByPosterId(@PathVariable Long posterId) {
        return new ResponseEntity<>(postService.findPostByPosterId(posterId), HttpStatus.OK);
    }

    private String timeConvert() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return myDateObj.format(myFormatObj);
    }
}
