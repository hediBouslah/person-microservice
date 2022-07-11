package com.microservicestutorial.usermanagement.service;

import com.microservicestutorial.usermanagement.exception.TechnicalException;
import com.microservicestutorial.usermanagement.persistence.Address;
import com.microservicestutorial.usermanagement.persistence.Person;
import com.microservicestutorial.usermanagement.persistence.PersonRepository;
import com.microservicestutorial.usermanagement.resource.mapper.PersonMapper;
import com.microservicestutorial.usermanagement.resource.to.PersonRequest;
import com.microservicestutorial.usermanagement.resource.to.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NamedQuery;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Integer calculateAge(Person person) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(person.getBirthdate());

        LocalDate today = LocalDate.now();

        LocalDate birthday = LocalDate.of(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1, //Calendar.Month {0 - 11}
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        return today.getYear() - birthday.getYear();
    }

    public PersonResponse createPerson(PersonRequest personRequest) {
        // TODO: PersonRequest and PersonResponse can be generated from Swagger
        Person personEntity = PersonMapper.MapToPersonEntity(personRequest);
        Person personEntityResult;
        try {
            personEntityResult = personRepository.save(personEntity);
        } catch (Exception e) {
            throw new TechnicalException("yabta fl habtaa", e.getCause());
        }

        return PersonMapper.MapToPersonResponse(personEntityResult);
    }

    //public List<Person> list() {
//        return personRepository.findAll();
//    }

    public PersonResponse updatePerson(PersonRequest personRequest, Long id) {

        Person existingPersonEntity  = personRepository.findById(id).orElseThrow(()-> new TechnicalException("Not found"));

        existingPersonEntity.setFirstName(personRequest.getFirstName());
        existingPersonEntity.setLastName(personRequest.getLastName());
        existingPersonEntity.setBirthdate(personRequest.getBirthdate());
        existingPersonEntity.setPhoneNumber(personRequest.getPhoneNumber());
        existingPersonEntity.setDepartmentId(personRequest.getDepartmentId());

        Person personEntityResult = personRepository.save(existingPersonEntity);
        return PersonMapper.MapToPersonResponse(personEntityResult);
    }

    public List<Person> getPs() {
        return personRepository.getPs();
    }

}
