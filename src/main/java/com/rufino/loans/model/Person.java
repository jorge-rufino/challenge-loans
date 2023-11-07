package com.rufino.loans.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	private BigDecimal income;
	private String location;
	
	@ManyToMany
	private List<Loan> loans = new ArrayList<>();
	
	public void addLoan (Loan loan) {
		this.loans.add(loan);
	}
	
	public void removeLoan (Loan loan) {
		this.loans.remove(loan);
	}
}
