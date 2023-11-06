package com.rufino.loans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rufino.loans.model.Person;
import com.rufino.loans.model.PersonDto;
import com.rufino.loans.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		
		return ResponseEntity.ok(personService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Person> createPerson(@RequestBody PersonDto dto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(dto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updatePerson(@PathVariable Long id, @RequestBody PersonDto dto){
		personService.updatePerson(id, dto);
		
		return ResponseEntity.noContent().build();		
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Void> updatePersonPartial(@PathVariable Long id, @RequestBody PersonDto dto){
		
		personService.updatePersonPartial(id, dto);
		
		return ResponseEntity.noContent().build();		
	}
}
