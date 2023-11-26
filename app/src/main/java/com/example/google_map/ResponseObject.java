package com.example.google_map;

public class ResponseObject {
    private String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseObject(String message) {
        this.message = message;
    }
}
