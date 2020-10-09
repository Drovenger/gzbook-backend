package com.gzbook.service.relationship;

import com.gzbook.model.friend.Relationship;

public interface IRelationshipService {
    Relationship findById(Long id);

    Iterable<Relationship> findAll();

    Relationship sreach(Long userId, Long friendId);
}
