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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/persons")
public class PersonRestService {
    @Autowired
    PersonService personService;

    @GetMapping
    String hello(){
        return "hello";
    }

    @PostMapping("/")
    ResponseEntity<PersonResponse> createPerson(@RequestBody PersonRequest personRequest){
        return new ResponseEntity<PersonResponse>(personService.createPerson(personRequest), HttpStatus.CREATED);
    }

    @PutMapping("/")
        ResponseEntity<PersonResponse>updatePerson(@RequestBody PersonRequest newPerson){
        return new ResponseEntity<PersonResponse>(personService.updatePerson(newPerson), HttpStatus.OK);
        }

    @GetMapping(value = "/")
    public ResponseEntity<List<Person>> findAllOrderByFirstNameAsc() {
        return new ResponseEntity<>(personService.findAllOrderByFirstNameAsc(), HttpStatus.OK);
    }

    /*@GetMapping(value = "/{lastName}")
    public ResponseEntity<Optional<List<Person>>> findPersonByLastName(@PathVariable("lastName") String lastName) {
        return new ResponseEntity<>(personService.findPersonByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping(value = "/{idPerson}")
    public ResponseEntity<Optional<Person>> findPersonById(@PathVariable("idPerson") Long idPerson) {
        return new ResponseEntity<>(personService.findPersonById(idPerson), HttpStatus.OK);

    }*/

    }


