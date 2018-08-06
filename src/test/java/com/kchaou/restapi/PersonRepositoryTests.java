package com.kchaou.restapi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kchaou.restapi.entities.Person;
import com.kchaou.restapi.repositories.IPersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTests {

	@Autowired
	IPersonRepository personRepo;

	@Test
	public void it_can_find_the_person_after_save_it() {
		Person person = new Person("7souna", "kachou", "paris", "css@css.com", "54545545");

		personRepo.save(person);

		List<Person> persons = personRepo.findAll();

		// assertEquals(5, persons.size());
		assertEquals("7souna", persons.get(2).getName());

	}

	@Test
	public void it_can_find_the_person_after_delete_it() {
		Person person = new Person("7souna", "kachou", "paris", "css@css.com", "54545545");

		personRepo.save(person);
		
		List<Person> persons = personRepo.findAll();

		personRepo.delete(persons.get(5));

		// assertEquals(5, persons.size());
		assertEquals("7souna", persons.get(2).getName());

	}

	@Test
	public void it_can_update_the_person_after_save_it() {

		Person person = new Person("7ammouda", "bou7mid", "tunis", "csscss@css.com", "9874949");

		personRepo.save(person);
		System.out.println("Id after save: " + person.getIdPesron());
		person.setMail("ahmed.kchaou@test.com");
		personRepo.save(person);

		List<Person> persons = personRepo.getAllByName("7ammouda");

		assertEquals("ahmed.kchaou@test.com", persons.get(0).getMail());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void failure_when_person_exists() throws Exception {
	  
	  Person person = new Person("7ammouda28", "bou7mid", "tunis", "csscss@css.com", "9874949");

	  person.setIdPesron((long) 28);

	  personRepo.save(person);
	}
}
