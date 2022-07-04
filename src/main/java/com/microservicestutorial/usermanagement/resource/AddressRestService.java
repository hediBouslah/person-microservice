package com.microservicestutorial.usermanagement.resource;

import com.microservicestutorial.usermanagement.persistence.Address;
import com.microservicestutorial.usermanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class AddressRestService {

    private final AddressService addressService;

    @Autowired
    public AddressRestService(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/v1/address")
    public ResponseEntity<List<Address>> findAllOrderByCountryAsc(){
        return new ResponseEntity<>(addressService.findAllOrderByCountryAsc(), HttpStatus.OK);
    }
    @GetMapping("/v1/address/paged")
    public ResponseEntity<Page<Address>> findAllPaged(Pageable pageRequest){
        return new ResponseEntity<>(addressService.findAllPaged(pageRequest), HttpStatus.OK);
    }
    @GetMapping("/v1/address/{id}")
    public ResponseEntity<Optional<Address>> findAddressByAddressId(@PathVariable("id") Long id){
        return new ResponseEntity<>(addressService.findByAddressId(id), HttpStatus.OK);
    }
    @GetMapping("/v1/address/country/{country}")
    public ResponseEntity<Optional<List<Address>>> findAddressByCountry(@PathVariable("country") String country){
        return new ResponseEntity<>(addressService.findAddressByCountry(country), HttpStatus.OK);
    }

    @PostMapping("/v1/address")
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        return new ResponseEntity<>(addressService.createAddress(address), HttpStatus.CREATED);
    }

    @PutMapping("/v1/address/update")
    public ResponseEntity<Address> updateAddress(@RequestBody Address newAddress){
        return new ResponseEntity<>(addressService.updateAddress(newAddress), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/v1/address/{id}")
    public ResponseEntity<HttpStatus> deleteAddressByAddressId(@PathVariable("id") Long id){
        addressService.deleteAddressByAddressId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
