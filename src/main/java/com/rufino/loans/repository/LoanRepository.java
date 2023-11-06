package com.rufino.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rufino.loans.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

}
