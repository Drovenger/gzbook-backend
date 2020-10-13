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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<Iterable<Post>> findAllByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(postService.findAllByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("status/{status}")
    public ResponseEntity<Iterable<Post>> findAllByStatus(@PathVariable Long status) {
        return new ResponseEntity<>(postService.findAllByStatus(status), HttpStatus.OK);
    }

    @PostMapping("userAndStatus/{userId}/{status}")
    public ResponseEntity<Iterable<Post>> findAllByUserIdAndStatus(@PathVariable Long userId,@PathVariable Integer status) {
        return new ResponseEntity<>(postService.findAllByUserIdAndStatus(userId, status), HttpStatus.OK);
    }

    @PostMapping("statusIn/{status}")
    public ResponseEntity<Iterable<Post>> findAllByStatusIn(@PathVariable int status) {
        return new ResponseEntity<>(postService.findAllByStatusIn(status), HttpStatus.OK);
    }

    @GetMapping()

    private String timeConvert() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return myDateObj.format(myFormatObj);
    }
}
