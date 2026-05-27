package com.eduhub.eduhub_backend.Exceptions;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String path;
    private String error;
    public ErrorResponse(LocalDateTime timestamp, int status, String message, String path, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
        this.error = error;
    }
}
