package com.microservicestutorial.usermanagement.service;

import com.microservicestutorial.usermanagement.exception.TechnicalException;
import com.microservicestutorial.usermanagement.persistence.Person;
import com.microservicestutorial.usermanagement.persistence.PersonRepository;
import com.microservicestutorial.usermanagement.resource.mapper.PersonMapper;
import com.microservicestutorial.usermanagement.resource.to.PersonRequest;
import com.microservicestutorial.usermanagement.resource.to.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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

    public PersonResponse updatePerson(PersonRequest personRequest, Long id) {
        Person existingPersonEntity = getPersonById(id);

        existingPersonEntity.setFirstName(personRequest.getFirstName());
        existingPersonEntity.setLastName(personRequest.getLastName());
        existingPersonEntity.setBirthdate(personRequest.getBirthdate());
        existingPersonEntity.setPhoneNumber(personRequest.getPhoneNumber());
        existingPersonEntity.setDepartmentId(personRequest.getDepartmentId());

        Person personEntityResult = personRepository.save(existingPersonEntity);
        return PersonMapper.MapToPersonResponse(personEntityResult);
    }

    public List<Person> getAllPersons() {
        return personRepository.getPersons();
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new TechnicalException("Person Not found"));
    }

    public PersonResponse deletePersonBuId(Long id) {
        PersonResponse personResponse = PersonMapper.MapToPersonResponse(getPersonById(id));
        personRepository.deleteById(id);
        return personResponse;
    }
}
