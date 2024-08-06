package com.example.model;

import jakarta.persistence.*;

public class BeRealCreateDto {
        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;
        private byte[] frontPhoto;
        private byte[] backPhoto;
        private String location;
        public byte[] getBackPhoto() {
            return backPhoto;
        }

        public void setBackPhoto(byte[] backPhoto) {
            this.backPhoto = backPhoto;
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
