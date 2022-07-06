package com.microservicestutorial.usermanagement.persistence;

import com.microservicestutorial.usermanagement.resource.to.PersonRequest;
import com.microservicestutorial.usermanagement.resource.to.PersonResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findById(long id);
   // List<Person> findPersonByLastName(String lastName);
    //void deletePersonByIdPerson(Long idPerson);
}
