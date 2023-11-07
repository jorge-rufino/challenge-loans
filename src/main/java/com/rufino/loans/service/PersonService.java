package com.rufino.loans.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rufino.loans.model.Person;
import com.rufino.loans.model.PersonDto;
import com.rufino.loans.model.Type;
import com.rufino.loans.repository.LoanRepository;
import com.rufino.loans.repository.PersonRepository;
import com.rufino.loans.util.Utils;

@Service
public class PersonService {

	final private BigDecimal limit1 = new BigDecimal("3000");
	final private BigDecimal limit2 = new BigDecimal("5000");
	final private int ageLimit = 30;
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	public List<Person> findAll(){
		return repository.findAll();
	}
	
	public Person createPerson(PersonDto dto) {
		Person newPerson = new Person();
		
		BeanUtils.copyProperties(dto, newPerson,"id");
		
		defineLoan(newPerson);
		
		return repository.save(newPerson);
	}
	
	public Person updatePerson(Long id, PersonDto dto) {
		Person updatePerson = repository.findById(id).orElseThrow(
				() -> new RuntimeException("Pessoa não encontrada."));
		
		updatePerson.getLoans().clear();
		
		BeanUtils.copyProperties(dto, updatePerson,"id");
		
		defineLoan(updatePerson);
		
		return repository.save(updatePerson);
	}
	
	public Person updatePersonPartial(Long id, PersonDto dto) {
		Person updatePerson = repository.findById(id).orElseThrow(
				() -> new RuntimeException("Pessoa não encontrada."));
		
		updatePerson.getLoans().clear();
		
		Utils.copyNonNullProperties(dto, updatePerson);
		
		defineLoan(updatePerson);
		
		return repository.save(updatePerson);
	}
	
	private Person defineLoan(Person person) {
		//Limite menor ou igual a 3000
		if(person.getIncome().compareTo(limit1) == -1 || person.getIncome().compareTo(limit1) == 0) {
			person.addLoan(loanRepository.findByType(Type.PERSONAL));
		}
		
		//Limite maior ou igual a 5000
		if(person.getIncome().compareTo(limit2) == 0 || person.getIncome().compareTo(limit2) == 1) {
			person.addLoan(loanRepository.findByType(Type.CONSIGNMENT));
		}
		
		//Limite maior que 3000 e menor que 5000, idade menor que 30 e morar em SP
		if(person.getIncome().compareTo(limit1) == 1 && person.getIncome().compareTo(limit2) == -1 && person.getAge() < ageLimit 
				&& person.getLocation().equals("SP")) {
			person.addLoan(loanRepository.findByType(Type.GUARANTEED));
		}
		
		return person;
	}
}
