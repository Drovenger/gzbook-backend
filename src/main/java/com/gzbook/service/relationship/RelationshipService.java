package com.gzbook.service.relationship;

import com.gzbook.model.friend.Relationship;
import com.gzbook.model.friend.Status;
import com.gzbook.repository.IRelationshipRepository;
import com.gzbook.service.status.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelationshipService implements IRelationshipService {
    @Autowired
    private IRelationshipRepository iRelationshipRepository;
    @Autowired
    private IStatusService statusService;
    @Override
    public Relationship saveRelationship(Relationship relationship) {
        return iRelationshipRepository.save(relationship);
    }

    @Override
    public void deleteRelationship(Long id) {
        iRelationshipRepository.deleteById(id);
    }

    @Override
    public Iterable<Relationship> findAllRelationship() {
        return iRelationshipRepository.findAll();
    }

    @Override
    public Relationship findRelationshipById(Long id) {
        return iRelationshipRepository.findById(id).get();
    }

    @Override
    public Iterable<Relationship> findAllByRelatedUserIdAndStatus(Long id, Status status) {
        return iRelationshipRepository.findAllByRelatedUserIdAndStatus(id,status);
    }

    @Override
    public Relationship findRelationshipByRelatingUserIdAndRelatedUserId(Long relatingId, Long relatedId) {
        return iRelationshipRepository.findRelationshipByRelatingUserIdAndRelatedUserId(relatingId,relatedId);
    }

    @Override
    public Iterable<Relationship> findAllByRelatingUserIdOrRelatedUserIdAndStatus(Long relatingUserId, Long relatedUserId, Status status) {
        return iRelationshipRepository.findAllByRelatingUserIdOrRelatedUserIdAndStatus(relatingUserId,relatedUserId,status);
    }

    @Override
    public Iterable<Relationship> findAllByRelatingUserIdAndStatusOrRelatedUserIdAndStatus(Long relatingUserId, Status status1, Long relatedUserId, Status status2) {
        return iRelationshipRepository.findAllByRelatingUserIdAndStatusOrRelatedUserIdAndStatus(relatingUserId,status1,relatedUserId,status2);
    }

    public List<Relationship> mutualFriends(Long userId, Long friendId){
        List<Relationship> temp = new ArrayList<>();
        List<Relationship> listFriendOfUser =
                (List<Relationship>) this.findAllByRelatedUserIdAndStatus(userId, statusService.findStatusById(2l));
        List<Relationship> listFriendOfFriend =
                (List<Relationship>) this.findAllByRelatedUserIdAndStatus(friendId, statusService.findStatusById(2l));
        for (Relationship i : listFriendOfUser){
            for (Relationship j : listFriendOfFriend){
                if (i.getRelatingUserId() == j.getRelatingUserId()){
                    temp.add(i);
                }
            }
        }
        return temp;
    }


}

