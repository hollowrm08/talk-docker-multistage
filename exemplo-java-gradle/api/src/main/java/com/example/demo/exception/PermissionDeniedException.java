package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class PermissionDeniedException extends AbstractException {
    public PermissionDeniedException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }
}
