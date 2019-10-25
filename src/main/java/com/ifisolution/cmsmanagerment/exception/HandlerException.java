package com.ifisolution.cmsmanagerment.exception;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(EntityNotFoundException ene) {
		return builResponseException(new ResponseException(ene, HttpStatus.NOT_FOUND));
	}

	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<Object> handleNotFoundException(EntityExistsException eee) {
		return builResponseException(new ResponseException(eee, HttpStatus.CONFLICT));
	}

	public ResponseEntity<Object> builResponseException(ResponseException re) {
		return new ResponseEntity<>(re, re.getStatus());
	}
}
