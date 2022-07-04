package com.microservicestutorial.usermanagement.resource;

import com.microservicestutorial.usermanagement.persistence.Person;
import com.microservicestutorial.usermanagement.persistence.PersonRepository;
import com.microservicestutorial.usermanagement.resource.to.PersonRequest;
import com.microservicestutorial.usermanagement.resource.to.PersonResponse;
import com.microservicestutorial.usermanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/persons")
public class PersonRestService {
    @Autowired
    PersonService personService;

    @GetMapping
    String hello(){
        return "hello";
    }

//    @GetMapping(value = "/")
//    ResponseEntity<List<Person>> list(){
//        return new ResponseEntity<>(this.personService.list(), HttpStatus.OK);
//    }



    @PostMapping("/")
    ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest personRequest){
        return new ResponseEntity<PersonResponse>(personService.createPerson(personRequest), HttpStatus.CREATED);
    }

}
