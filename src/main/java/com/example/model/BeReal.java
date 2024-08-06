package com.example.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class BeReal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long beRealId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private byte[] frontPhoto;
    private byte[] backPhoto;
    private String location;
    private LocalDateTime dateCreated = LocalDateTime.now();

    public byte[] getBackPhoto() {
        return backPhoto;
    }

    public void setBackPhoto(byte[] backPhoto) {
        this.backPhoto = backPhoto;
    }

    public Long getBeRealId() {
        return beRealId;
    }

    public void setBeRealId(Long beRealId) {
        this.beRealId = beRealId;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public byte[] getFrontPhoto() {
        return frontPhoto;
    }

    public void setFrontPhoto(byte[] frontPhoto) {
        this.frontPhoto = frontPhoto;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
