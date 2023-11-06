package com.rufino.loans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rufino.loans.model.Loan;
import com.rufino.loans.model.Type;
import com.rufino.loans.repository.LoanRepository;

import jakarta.annotation.PostConstruct;

@Service
public class LoanMock {

	@Autowired
	private LoanRepository repository;
	
	@PostConstruct
	private void createMockLoans() {
		Loan l1 = new Loan(1L,Type.PERSONAL,4.0);
		Loan l2 = new Loan(2L,Type.CONSIGNMENT,2.0);
		Loan l3 = new Loan(3L,Type.GUARANTEED,3.0);
		
		repository.save(l1);
		repository.save(l2);
		repository.save(l3);
	}
}

