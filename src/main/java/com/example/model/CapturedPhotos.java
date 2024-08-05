package com.example.model;

public class CapturedPhotos {
    private PhotoCreateDto front;

    private PhotoCreateDto back;

    public PhotoCreateDto getBack() {
        return back;
    }

    public void setBack(PhotoCreateDto back) {
        this.back = back;
    }

    public PhotoCreateDto getFront() {
        return front;
    }

    public void setFront(PhotoCreateDto front) {
        this.front = front;
    }
}
