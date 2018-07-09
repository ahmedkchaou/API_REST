package com.kchaou.javalabs.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kchaou.javalabs.entities.Person;
import com.kchaou.javalabs.repositories.IPersonRepository;

@RestController
@RequestMapping(value = "/personKCH/v1")
public class PersonController {

	@Autowired
	private IPersonRepository personRepo;
	
	//Methode d'envoi => @RequestMapping(value="/create", method=RequestMethod.POST)
	@PostMapping(value="/create")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		
		try {
		
		personRepo.save(person);
		HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "Creation succès");
 	    return new ResponseEntity<Person>(person, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<Person>(HttpStatus.CONFLICT);
		}
    //return new ResponseEntity<List <Person>>(HttpStatus.NOT_FOUND);
        //return ResponseEntity.accepted().headers(headers).body(person);
	}

	
	@PutMapping(value="/update/{id}") //Put c'est qu'on peut modifier
	public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
		
		if(id != null) {
			Optional<Person> p = personRepo.findById(id);
			if (p !=null) {
				person.setIdPesron(id);
			person = personRepo.save(person);
			}
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		   responseHeaders.set("MyResponseHeader", "Update succes");
		 
        return new ResponseEntity<Person>(person, responseHeaders, HttpStatus.ACCEPTED);
        
        //return ResponseEntity.accepted().headers(headers).body(person);
			
	}
	
	@DeleteMapping(value ="/delete/{id}")
	public void deletePerson(@PathVariable Long id) {
		
		if(id != null) {
			Optional<Person> p = personRepo.findById(id);
			if (p !=null) {
			personRepo.deleteById(id);
			}
		}	
	}
	
	//@GetMapping(value = "/all")
	@RequestMapping(path="/all",method=RequestMethod.GET)
	public ResponseEntity<List <Person>>  getAll(){
		
		List<Person> persons = personRepo.findAll();
		 return ResponseEntity.ok(persons);  // return 200, with json body
   //	return ResponseEntity.ok(personRepo.findAll()) ;
		 
   
	}
	
	@GetMapping(value = "/all/by/name/{name}")
	public List<Person> getAllByName(@PathVariable String name){
		return personRepo.getAllByName(name);
	}
	/*
	@RequestMapping(value = "/all/by/persons/{id}")
    public ResponseEntity<Person> getPersonById (@PathVariable("id") Long id)
    {
        if (id <= 3) {
        	Person person = new Person();
        	person.setIdPesron(id);
            return new ResponseEntity<Person>(person, HttpStatus.OK);
        }
        return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
    }
	*/
	@GetMapping(value = "/all/by/name/{name}/adress/{adress}")
	//(@PathVariable long fooid, @PathVariable long barid) 
	public ResponseEntity<List <Person>> getAllByNameAdress(@PathVariable String name,@PathVariable String adress){
		
		if (name .equals("CSS")) {
		List<Person> persons = personRepo.getAllByNameAndAdress(name,adress);
		   return new ResponseEntity<List <Person>>(persons, HttpStatus.OK);
        }
        return new ResponseEntity<List <Person>>(HttpStatus.NOT_FOUND);
	}
	
	
	
	
}
