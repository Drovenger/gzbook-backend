package com.gzbook.model;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long friendId;
//    @ManyToOne
//    @JoinColumn(name = "status_id")
//    private Status status;

    public Contact() {
    }
    public Contact(Long relatingUserId,Long relatedUserId ) {

        this.userId = relatingUserId;
        this.friendId = relatedUserId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }
}
