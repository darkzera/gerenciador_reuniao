package com.digitalinovation.gerenciadorreuniao.exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (ResourceNotFound.class)
    public ResponseEntity<?> resourceNotFound(ResourceNotFound ex, WebRequest req){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<?> globalExceptionHandler(ResourceNotFound ex, WebRequest req){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
