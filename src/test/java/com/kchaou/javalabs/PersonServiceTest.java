package com.kchaou.javalabs;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kchaou.javalabs.repositories.IPersonRepository;
import com.kchaou.javalabs.services.PersonServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {
	
	@Mock
	private IPersonRepository personRepo;
	
	@InjectMocks
	private PersonServiceImpl personService;
	
	

}
