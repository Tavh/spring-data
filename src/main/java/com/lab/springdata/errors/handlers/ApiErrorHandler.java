package com.lab.springdata.errors.handlers;

import javax.validation.ConstraintViolationException; 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lab.springdata.errors.errorresponses.ApiError;

@ControllerAdvice
public class ApiErrorHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ApiError> handleConstraintViolationException(ConstraintViolationException e) {
		return new ResponseEntity<ApiError>(new ApiError(e.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
}
