package com.gzbook.controller;

import com.gzbook.model.Contact;
import com.gzbook.model.User;
import com.gzbook.service.contact.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private IContactService iContactService;

    public Contact checkContack(Long friendId, Long userId) {
        Contact contact;
        if (iContactService.findContactByUserIdAndFriendId(friendId,userId) !=null){
            contact = iContactService.findContactByUserIdAndFriendId(friendId,userId);
        } else contact = null;
        return contact;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Contact>> findAll() {
        return new ResponseEntity<>(iContactService.findAllContact(), HttpStatus.OK);
    }

    @PostMapping("/creat/{friendId}")
    public ResponseEntity<Contact> addInviteFriend(@PathVariable Long friendId, @RequestBody User user) {
    Contact contact =this.checkContack(friendId, user.getId());
    if (contact == null) {
        Contact contact1 = new Contact(friendId, user.getId());

    }
        return null;
    }


}
