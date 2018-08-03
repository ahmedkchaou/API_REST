package com.kchaou.javalabs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kchaou.javalabs.entities.Person;
import com.kchaou.javalabs.repositories.IPersonRepository;

@Service("personService")
public class PersonServiceImpl implements PersonService{

	@Autowired
	private IPersonRepository personRepo;
	
	@Override
	public List<Person> getAllPerson() {
		// TODO Auto-generated method stub
		return personRepo.findAll();
	}


	@Override
	public Person savePerson(Person person) {
		// TODO Auto-generated method stub
		return personRepo.save(person);
	}

	@Override
	public void removePerson(Person person) {
		// TODO Auto-generated method stub
		
		personRepo.delete(person);
		
	}


	@Override
	public Person getPersonById(long id) {
		
		return personRepo.findById(id).get();
	}


	@Override
	public Person findByName(String name) {
		
		return personRepo.findByName(name);
	}

}
