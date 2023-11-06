package com.rufino.loans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rufino.loans.model.Loan;
import com.rufino.loans.repository.LoanRepository;

@RestController
@RequestMapping("customer-loans")
public class LoanController {

	@Autowired
	private LoanRepository repository;
	
	@PostMapping
	public Loan teste(@RequestBody Loan loan) {
		return repository.save(loan);
	}
	
	@GetMapping
	public List<Loan> findAll(){
		return repository.findAll();
	}
}
