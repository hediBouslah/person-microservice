package com.microservicestutorial.usermanagement.resource;

import com.microservicestutorial.usermanagement.persistence.Person;
import com.microservicestutorial.usermanagement.resource.to.PersonRequest;
import com.microservicestutorial.usermanagement.resource.to.PersonResponse;
import com.microservicestutorial.usermanagement.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/persons")
public class PersonRestService {
    private final PersonService personService;

    @Autowired
    public PersonRestService(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/")
    PersonResponse createPerson(@RequestBody PersonRequest personRequest){
        return personService.createPerson(personRequest);
    }

    // PATCH = partial update && PUT = update the entire resource
    @PutMapping("/{id}")
    PersonResponse updatePerson(@RequestBody PersonRequest personRequest,
                                                @PathVariable Long id){
        return personService.updatePerson(personRequest, id);
    }

    @GetMapping("/")
    List<Person> getAll(){
        return personService.getPs();
    }

}
