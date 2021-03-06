package com.microservicestutorial.usermanagement.resource.mapper;

import com.microservicestutorial.usermanagement.persistence.Person;
import com.microservicestutorial.usermanagement.resource.to.PersonRequest;
import com.microservicestutorial.usermanagement.resource.to.PersonResponse;

public class PersonMapper {
    public static Person MapToPersonEntity(PersonRequest personRequest) {
        Person person = new Person();

        if(personRequest.getId() != null){
            person.setPersonId(personRequest.getId());
        }
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        person.setBirthdate(personRequest.getBirthdate());
        person.setPhoneNumber(personRequest.getPhoneNumber());
        person.setDepartmentId(personRequest.getDepartmentId());

        return person;
    }

    public static PersonResponse MapToPersonResponse(Person personEntity) {
        PersonResponse personResponse = new PersonResponse();

        personResponse.setId(personEntity.getPersonId());
        personResponse.setFirstName(personEntity.getFirstName());
        personResponse.setLastName(personEntity.getLastName());
        personResponse.setBirthdate(personEntity.getBirthdate());
        personResponse.setPhoneNumber(personEntity.getPhoneNumber());
        personResponse.setDepartmentId(personEntity.getDepartmentId());

        return personResponse;
    }
}
