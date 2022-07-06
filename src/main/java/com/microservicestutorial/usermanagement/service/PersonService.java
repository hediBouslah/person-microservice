package com.microservicestutorial.usermanagement.service;

import com.microservicestutorial.usermanagement.exception.TechnicalException;
import com.microservicestutorial.usermanagement.persistence.Person;
import com.microservicestutorial.usermanagement.persistence.PersonRepository;
import com.microservicestutorial.usermanagement.resource.mapper.PersonMapper;
import com.microservicestutorial.usermanagement.resource.to.PersonRequest;
import com.microservicestutorial.usermanagement.resource.to.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public List<Person> list() {
        return personRepository.findAll();
    }

   /* public Person updatePerson(Person newPerson) {

        Optional<Person> personToUpdate = personRepository.findById(newPerson.getId());
        if (personToUpdate.isPresent()) {
            Person _person = personToUpdate.get();
            _person.setFirstName(newPerson.getFirstName());
            _person.setLastName(newPerson.getLastName());
            _person.setPhoneNumber(newPerson.getPhoneNumber());
            _person.setBirthdate(newPerson.getBirthdate());
            return personRepository.save(_person);
        } else

            return null;
    }*/

    public PersonResponse updatePerson(PersonRequest newPerson) {
        Person personEntity = PersonMapper.MapToPersonEntity(newPerson);
        Person personEntityResult;
        Optional<Person> personToUpdate = personRepository.findById(newPerson.getId());
        if (personToUpdate.isPresent()) {
            Person _person = personToUpdate.get();
            _person.setFirstName(newPerson.getFirstName());
            _person.setLastName(newPerson.getLastName());
            _person.setPhoneNumber(newPerson.getPhoneNumber());
            _person.setBirthdate(newPerson.getBirthdate());
            _person.setDepartmentId(newPerson.getDepartmentId());

            personEntityResult = personRepository.save(_person);

        return PersonMapper.MapToPersonResponse(personEntityResult);}
        else

        return null;
    }



   /* public Optional<PersonResponse> findPersonById(Long id) {

        Person personEntity = PersonMapper.MapToPersonEntity(id);
        Person personEntityResult;

        Optional<Person> person = personRepository.findById(id);
        {
            if (person.isPresent()) {
                return PersonMapper.MapToPersonResponse(personEntityResult);
            }
            return null;
        }
    }



    public List<Person> findAllOrderByFirstNameAsc(){
       return personRepository.findAll(Sort.by("firstName"));
    }

    public Optional<List<Person>> findPersonByLastName(String lastName) {
        return Optional.ofNullable(personRepository.findPersonByLastName(lastName));
    }
*/



}









