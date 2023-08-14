package com.example.demo;

import java.util.Date;

public class ApiError {
    private Date timestamp;
    private int status;
    private String error;
    private String message;

    public ApiError(int status, String error, String message) {
        this.timestamp = new Date();
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
