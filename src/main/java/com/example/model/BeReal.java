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

    private String frontPhotoUrl;
    private String backPhotoUrl;
    private String location;
    private LocalDateTime dateCreated = LocalDateTime.now();

    public String getBackPhotoUrl() {
        return backPhotoUrl;
    }

    public void setBackPhotoUrl(String backPhotoUrl) {
        this.backPhotoUrl = backPhotoUrl;
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

    public String getFrontPhotoUrl() {
        return frontPhotoUrl;
    }

    public void setFrontPhotoUrl(String frontPhotoUrl) {
        this.frontPhotoUrl = frontPhotoUrl;
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
