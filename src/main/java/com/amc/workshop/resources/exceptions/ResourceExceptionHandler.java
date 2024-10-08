package com.amc.workshop.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amc.workshop.services.exceptions.DataBaseException;
import com.amc.workshop.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
    String error = "Resource not found";
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError sr = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(sr);
  }

  @ExceptionHandler(DataBaseException.class)
  public ResponseEntity<StandardError> databaseException(DataBaseException e, HttpServletRequest request) {
    String error = "DataBase error";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError bdsr = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(bdsr);
  }
}