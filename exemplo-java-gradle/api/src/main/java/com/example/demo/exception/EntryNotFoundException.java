package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntryNotFoundException extends AbstractException {
    public EntryNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
