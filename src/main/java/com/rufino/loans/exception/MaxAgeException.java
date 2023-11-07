package com.rufino.loans.exception;

public class MaxAgeException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MaxAgeException(String message) {
		super(message);
	}
}
