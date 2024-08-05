package com.example.model;

import jakarta.persistence.*;

@Entity
public class Friendship {
    @EmbeddedId
    private FriendshipKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("friendId")
    @JoinColumn(name = "friend_id")
    private User friend;

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }

    public FriendshipKey getId() {
        return id;
    }

    public void setId(FriendshipKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
