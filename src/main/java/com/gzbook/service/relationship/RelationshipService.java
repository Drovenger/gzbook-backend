package com.gzbook.service.relationship;

import com.gzbook.model.friend.Relationship;
import com.gzbook.repository.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationshipService implements IRelationshipService{
    @Autowired
    private RelationshipRepository relationshipRepository;
    @Override
    public Relationship findById(Long id) {
        return relationshipRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Relationship> findAll() {
        return relationshipRepository.findAll();
    }

    @Override
    public Relationship sreach(Long userId, Long friendId) {
       return relationshipRepository.findByRelatingUserIdAndRelatedUserId(userId, friendId);
    }

}
