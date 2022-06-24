/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.regApp.exceptionHandler;

import com.example.regApp.model.ErrorDetails;
import java.sql.Date;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Arosha
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    //for handle invalid userid
    @ExceptionHandler(InvalidConfigurationPropertyValueException.class)
    public ResponseEntity<?> handleInvalidPropertyValueException
        (InvalidConfigurationPropertyValueException exception, WebRequest request) {

        long millis = System.currentTimeMillis();
        ErrorDetails errorDetails = new ErrorDetails(new Date(millis), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
    }

    //for handle global exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException
        (Exception exception, WebRequest request) {

        long millis = System.currentTimeMillis();
        ErrorDetails errorDetails = new ErrorDetails(new Date(millis), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
