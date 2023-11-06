package com.rufino.loans.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rufino.loans.model.Person;
import com.rufino.loans.model.PersonDto;
import com.rufino.loans.repository.PersonRepository;
import com.rufino.loans.util.Utils;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public List<Person> findAll(){
		return repository.findAll();
	}
	
	public Person createPerson(PersonDto dto) {
		Person newPerson = new Person();
		
		BeanUtils.copyProperties(dto, newPerson,"id");
		
		return repository.save(newPerson);
	}
	
	public Person updatePerson(Long id, PersonDto dto) {
		Person updatePerson = repository.findById(id).orElseThrow(
				() -> new RuntimeException("Pessoa não encontrada."));
		
		BeanUtils.copyProperties(dto, updatePerson,"id");
		
		return repository.save(updatePerson);
	}
	
	public Person updatePersonPartial(Long id, PersonDto dto) {
		Person updatePerson = repository.findById(id).orElseThrow(
				() -> new RuntimeException("Pessoa não encontrada."));
		
		Utils.copyNonNullProperties(dto, updatePerson);
		
		return repository.save(updatePerson);
	}
}
