package com.kchaou.javalabs;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kchaou.javalabs.entities.Person;
import com.kchaou.javalabs.repositories.IPersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	IPersonRepository personRepo;

	/*
	 * "idPesron": 1, "name": "Ahmed", "familyName": "kchaou", "adress": "paris",
	 * "mail": "kchaou@gmail.com", "phone": "0664984639"
	 */

	@Test
	public void it_can_find_the_person_after_save_it() {
		Person contact = new Person("7souna", "kachou", "paris", "css@css.com", "54545545");

		// personRepo.save(contact);

		List<Person> contacts = personRepo.findAll();

		// assertEquals(5, contacts.size());
		assertEquals("7souna", contacts.get(2).getName());

	}

	@Test
	public void it_can_find_the_person_after_delete_it() {
		Person contact = new Person("7souna", "kachou", "paris", "css@css.com", "54545545");

		List<Person> contacts = personRepo.findAll();

		personRepo.delete(contacts.get(5));

		// assertEquals(5, contacts.size());
		assertEquals("7souna", contacts.get(2).getName());

	}

	@Test
	public void it_can_update_the_person_after_save_it() {

		Person contact = new Person("7ammouda", "bou7mid", "tunis", "csscss@css.com", "9874949");

		personRepo.save(contact);
		System.out.println("Id after save: "+contact.getIdPesron());
		contact.setMail("ahmed.kchaou@test.com");
		personRepo.save(contact);

		List<Person> contacts = personRepo.getAllByName("7ammouda");

		assertEquals("ahmed.kchaou@test.com", contacts.get(0).getMail());
	}
}
