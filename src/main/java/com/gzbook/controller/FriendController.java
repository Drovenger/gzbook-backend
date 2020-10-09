package com.gzbook.controller;

import com.gzbook.model.comment.Comment;
import com.gzbook.model.friend.Relationship;
import com.gzbook.service.relationship.IRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private IRelationshipService relationshipService;
    @GetMapping("/{id}")
    public ResponseEntity<Relationship> findById(@PathVariable Long id ) {
        return new ResponseEntity<>(relationshipService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{userId}/{friendId}")
    public ResponseEntity<Relationship> check(@PathVariable Long userId,@PathVariable Long friendId) {
        return new ResponseEntity<>(relationshipService.sreach(userId, friendId), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Relationshigp>> search() {
        return new ResponseEntity<Iterable<Relationship>>(relationshipService.findAll(), HttpStatus.OK);
    }
}
