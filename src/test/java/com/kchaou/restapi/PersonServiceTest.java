package com.kchaou.restapi;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kchaou.restapi.entities.Person;
import com.kchaou.restapi.repositories.IPersonRepository;
import com.kchaou.restapi.services.PersonServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {

	@Mock
	private IPersonRepository personRepo;

	@InjectMocks
	private PersonServiceImpl personService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void get_all_persons() {

		List<Person> personList = new ArrayList<Person>();

		personList.add(new Person("bou7a", "bouhamed", "Courbevoie", "bou7a@gmail.com", "06631645848"));

		when(personRepo.findAll()).thenReturn(personList);

		List<Person> result = personService.getAllPerson();

		assertEquals(1, result.size());
	}
	
	@Test
	public void get_person_by_name() {
		
		Person person = new Person("bou7a", "bouhamed", "Courbevoie", "bou7a@gmail.com", "06631645848");

		when(personRepo.findByName("bou7a")).thenReturn(person);
		
		Person p = personService.findByName(person.getName());
		
		assertEquals("bou7a", p.getName());
	}

	@Test
	public void save_person() {

		Person person = new Person("bou7a", "bouhamed", "Courbevoie", "bou7a@gmail.com", "06631645848");

		when(personRepo.save(person)).thenReturn(person);

		Person p = personService.savePerson(person);

		assertEquals("bou7a", p.getName());
		assertEquals("bouhamed", p.getFamilyName());
	}

	@Test
	public void remove_person() {

		Person person = new Person("bou7a", "bouhamed", "Courbevoie", "bou7a@gmail.com", "06631645848");

		personService.removePerson(person);

		verify(personRepo, times(1)).delete(person);

	}
}
