package com.rufino.loans.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleNoSuchElementException(EntityNotFoundException exception) {
		ExceptionDto dto = new ExceptionDto(exception.getMessage(), "400");

		return ResponseEntity.badRequest().body(dto);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
		ExceptionDto dto = new ExceptionDto("Dados passados são inválidos.", "400");

		return ResponseEntity.badRequest().body(dto);
	}
	
	@ExceptionHandler(MaxAgeException.class)
	public ResponseEntity<?> handleMaxAgeException(MaxAgeException exception) {
		ExceptionDto dto = new ExceptionDto(exception.getMessage(), "400");

		return ResponseEntity.badRequest().body(dto);
	}
	
	@ExceptionHandler(NegativeIncomeException.class)
	public ResponseEntity<?> handleNegativeIncomeException(NegativeIncomeException exception) {
		ExceptionDto dto = new ExceptionDto(exception.getMessage(), "400");

		return ResponseEntity.badRequest().body(dto);
	}
}
