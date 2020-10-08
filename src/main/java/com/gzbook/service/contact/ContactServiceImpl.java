package com.gzbook.service.contact;

import com.gzbook.model.Contact;
import com.gzbook.repository.IContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements IContactService {
    @Autowired
    private IContactRepository iContactRepository;

    @Override
    public Contact saveContact(Contact contact) {
        return iContactRepository.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        iContactRepository.deleteById(id);
    }

    @Override
    public Iterable<Contact> findAllContact() {
        return iContactRepository.findAll();
    }

    @Override
    public Contact findContactById(Long id) {
        return iContactRepository.getOne(id);
    }

    @Override
    public Contact findContactByUserIdAndFriendId(Long friendId, Long userId) {
        return iContactRepository.findByUserIdAndFriendId(friendId, userId);
    }
}
