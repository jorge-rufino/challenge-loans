package com.rufino.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rufino.loans.model.Loan;
import com.rufino.loans.model.Type;

public interface LoanRepository extends JpaRepository<Loan, Long>{

	Loan findByType(Type type);	
}
