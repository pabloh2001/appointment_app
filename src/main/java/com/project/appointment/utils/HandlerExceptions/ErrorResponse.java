package com.project.appointment.utils.HandlerExceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timeStamp;
    List<String> errors;

    public ErrorResponse() {
    }

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse(int status, String message, LocalDateTime timeStamp, List<String> errors) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
