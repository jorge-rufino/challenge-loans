package com.rufino.loans.exception;

public class NegativeIncomeException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NegativeIncomeException(String message) {
		super(message);
	}
}
