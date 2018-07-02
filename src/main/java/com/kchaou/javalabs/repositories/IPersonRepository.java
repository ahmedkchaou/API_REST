package com.kchaou.javalabs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kchaou.javalabs.entities.Person;

public interface IPersonRepository extends JpaRepository<Person, Long>{

	public List<Person> getAllByName(String name);
	
	public List<Person> getAllByNameAndAdress (String name, String adress);
}
