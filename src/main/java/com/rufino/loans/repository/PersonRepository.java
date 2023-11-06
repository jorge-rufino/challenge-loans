package com.rufino.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rufino.loans.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
