package com.gzbook.service.contact;

import com.gzbook.model.Contact;

public interface IContactService {
    Contact saveContact(Contact contact);
    void deleteContact(Long id);
    Iterable<Contact> findAllContact();
    Contact findContactById(Long id);
    Contact findContactByUserIdAndFriendId (Long friendId, Long userId);
}
