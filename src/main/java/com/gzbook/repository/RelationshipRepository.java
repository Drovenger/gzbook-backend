package com.gzbook.repository;

import com.gzbook.model.friend.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
    Relationship findByRelatingUserIdAndRelatedUserId(Long userId, Long friendId);
}
