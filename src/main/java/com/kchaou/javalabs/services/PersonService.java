package com.kchaou.javalabs.services;

import java.util.List;

import com.kchaou.javalabs.entities.Person;

public interface PersonService {

	public List<Person> getAllPerson();

	public Person getPersonById(long id);

	public Person savePerson(Person person);

	public void removePerson(Person person);
	
	public Person findByName(String name);

}
