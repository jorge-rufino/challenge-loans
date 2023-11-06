package com.rufino.loans.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private int age;
	private String cpf;	
	private double income;
	private String location;
	
	public Person(PersonDto dto) {
		this.name = dto.name();
		this.age = dto.age();
		this.cpf = dto.cpf();
		this.income = dto.income();
		this.location = dto.location();
	}
}
