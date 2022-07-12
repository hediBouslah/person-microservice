package com.microservicestutorial.usermanagement.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {


    @Query(value = "select * from t_persons" ,nativeQuery = true)
    List<Person> getPersons();

//    @Query(value = "select * from t_addresses a where a.person_id = t_persons.id", nativeQuery = true)
//    Address getAddressFromPerson(Long personId);



}
