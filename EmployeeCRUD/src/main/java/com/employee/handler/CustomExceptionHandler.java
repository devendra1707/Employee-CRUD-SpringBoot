package com.employee.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFound(EmployeeNotFoundException enfe) {
		return new ResponseEntity<String>(enfe.getMessage(), HttpStatus.NOT_FOUND);
	}
}
