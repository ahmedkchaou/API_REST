package com.kchaou.javalabs.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kchaou.exception.PersonException;
import com.kchaou.javalabs.entities.Person;
import com.kchaou.javalabs.services.PersonService;

@RestController
@RequestMapping(value = "/person/v1")
public class PersonController {

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getAllToDo() {
		logger.info("Returning all the Person´s");
		return new ResponseEntity<List<Person>>(personService.getAllPerson(), HttpStatus.OK);
	}

	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> getPersonById(@PathVariable("id") long id) throws PersonException {
		logger.info("Person id to return " + id);
		Person person = personService.getPersonById(id);
		if (person == null || person.getIdPesron() <= 0) {
			throw new PersonException("Person doesn´t exist");
		}
		return new ResponseEntity<Person>(personService.getPersonById(id), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deletePerson(@PathVariable Long id) {

		if (id != null) {
			Person p = personService.getPersonById(id);
			if (p != null) {
				personService.removePerson(p);
			}
		}
	}

	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	public ResponseEntity<Person> savePerson(@RequestBody Person person) throws PersonException {
		logger.info("Person to save " + person);

		return new ResponseEntity<Person>(personService.savePerson(person), HttpStatus.OK);
	}

	@RequestMapping(value = "/updatePerson", method = RequestMethod.PATCH)
	public ResponseEntity<Person> updatePerson(@RequestBody Person person) throws PersonException {
		logger.info("Person to update " + person);
		Person p = personService.getPersonById(person.getIdPesron());
		if (p == null || p.getIdPesron() <= 0) {
			throw new PersonException("Person to update doesn´t exist");
		}
		return new ResponseEntity<Person>(personService.savePerson(person), HttpStatus.OK);
	}

	
}
