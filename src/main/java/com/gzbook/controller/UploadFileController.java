package com.gzbook.controller;

import com.gzbook.model.post.Post;
import com.gzbook.model.user.User;
import com.gzbook.service.post.IPostService;
import com.gzbook.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/photo")
public class UploadFileController {

    @Autowired
    private Environment environment;

    @Autowired
    private IUserService userService;

    @Autowired
    private IPostService postService;

    @RequestMapping("/avatar/{userId}")
    public ResponseEntity<HttpStatus> setUrlAvatar(@PathVariable Long userId, @RequestBody String uri){
        User user = userService.findUserById(userId);
        user.setAvatarUrl(uri);
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping("/coverPhoto/{userId}")
    public ResponseEntity<HttpStatus> setUrlCoverAvatar(@PathVariable Long userId, @RequestBody String uri){
        User user = userService.findUserById(userId);
        user.setCoverPhotoUrl(uri);
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping("/postPhoto/{postId}")
    public ResponseEntity<HttpStatus> setUrlPostPhoto(@PathVariable Long postId, @RequestBody String uri){
        Post post = postService.findPostById(postId);
        post.setPhoto(uri);
        postService.savePost(post);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<String> fileUpload(@RequestParam Map<String, MultipartFile> data) {
        MultipartFile file = data.get("image");

        String fileName = file.getOriginalFilename();
        String fileUpload = environment.getProperty("upload.path");
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
