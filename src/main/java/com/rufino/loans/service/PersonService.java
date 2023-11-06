package com.rufino.loans.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rufino.loans.model.Person;
import com.rufino.loans.model.PersonDto;
import com.rufino.loans.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public List<Person> findAll(){
		return repository.findAll();
	}
	
	public Person createPerson(PersonDto dto) {
		Person newPerson = new Person(dto);
		
		return repository.save(newPerson);
	}
}
