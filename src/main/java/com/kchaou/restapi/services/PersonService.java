package com.kchaou.restapi.services;

import java.util.List;

import com.kchaou.restapi.entities.Person;

public interface PersonService {

	public List<Person> getAllPerson();

	public Person getPersonById(long id);

	public Person savePerson(Person person);

	public void removePerson(Person person);
	
	public Person findByName(String name);

}
