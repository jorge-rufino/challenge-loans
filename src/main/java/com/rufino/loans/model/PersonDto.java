package com.rufino.loans.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record PersonDto(
		@NotNull
		int age, 
		
		@NotBlank
		String name, 
		
		@NotBlank
		String cpf, 
		
		@NotNull
		@PositiveOrZero
		BigDecimal income, 
		
		@NotBlank
		String location) {

}
