package com.rufino.loans.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleConstraintViolationException(MethodArgumentNotValidException exception) {
		
		List<FieldError> list = exception.getFieldErrors();
		
		String message = "";		
		
		for(FieldError obj : list) {
			String field = obj.getField();
			
			if(field.equals("age")) {
				message = "Campo age inválido ou nulo.";
			}
			
			if(field.equals("name")) {
				message = "Campo name inválido ou nulo.";
			}
			
			if(field.equals("cpf")) {
				message = "Campo cpf inválido ou nulo.";
			}
			
			if(field.equals("income")) {
				message = "Campo income inválido ou nulo.";
			}
			
			if(field.equals("location")) {
				message = "Campo location inválido ou nulo.";
			}
		}
		
		ExceptionDto dto = new ExceptionDto(message, "400");
		
		return ResponseEntity.badRequest().body(dto);
	}
}
