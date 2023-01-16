package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LoginIsBlankException extends AbstractException {
    public LoginIsBlankException() {
        super("O login não foi informado", HttpStatus.BAD_REQUEST);
    }
}
