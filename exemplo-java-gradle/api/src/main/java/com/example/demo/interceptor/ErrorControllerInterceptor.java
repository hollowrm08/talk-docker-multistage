package com.example.demo.interceptor;

import com.example.demo.controller.response.ErrorResponse;
import com.example.demo.exception.EntryNotFoundException;
import com.example.demo.exception.LoginIsBlankException;
import com.example.demo.exception.PermissionDeniedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ControllerAdvice
public class ErrorControllerInterceptor {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        log.error("Ocorreu um erro inesperado: " + exception.getMessage(), exception);
        return buildResponse("Ocorreu um erro inesperado na aplicação", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(EntryNotFoundException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception.getMessage(), exception.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(LoginIsBlankException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception.getMessage(), exception.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(PermissionDeniedException exception) {
        log.error(exception.getMessage(), exception);
        return buildResponse(exception.getMessage(), exception.getStatus());
    }

    private ResponseEntity<ErrorResponse> buildResponse(String menssage, HttpStatus httpStatus) {
        ErrorResponse errorResponse = new ErrorResponse(menssage, httpStatus.value());
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

}
