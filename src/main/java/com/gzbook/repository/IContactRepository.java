package com.gzbook.repository;

import com.gzbook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends JpaRepository<Contact,Long> {
    Contact findByUserIdAndFriendId(Long friendID, Long userId);
}
