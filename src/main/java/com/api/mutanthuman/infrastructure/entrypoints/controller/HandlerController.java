package com.api.mutanthuman.infrastructure.entrypoints.controller;

import com.api.mutanthuman.domain.exception.ApplicationException;
import com.api.mutanthuman.domain.exception.InvalidCharacterException;
import com.api.mutanthuman.domain.exception.MalformedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class HandlerController {
    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity<Object> handlerApplicationException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler({InvalidCharacterException.class, MalformedException.class })
    public ResponseEntity<Object> handlerInvalidCharacterException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
