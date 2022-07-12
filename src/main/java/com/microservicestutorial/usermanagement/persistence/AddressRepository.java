package com.microservicestutorial.usermanagement.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

//    List<Address> findByCountry(String country);
//
//    //Address findByAddressId(Long id);
//
//    void deleteAddressByAddressId(Long id);
}
