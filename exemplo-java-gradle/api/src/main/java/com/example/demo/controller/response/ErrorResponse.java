package com.example.demo.controller.response;

import lombok.Data;

@Data
public class ErrorResponse {
    private final String message;
    private final int status;
}
