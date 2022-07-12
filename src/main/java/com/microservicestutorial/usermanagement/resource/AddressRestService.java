package com.microservicestutorial.usermanagement.resource;

import com.microservicestutorial.usermanagement.persistence.Address;
import com.microservicestutorial.usermanagement.resource.to.AddressRequest;
import com.microservicestutorial.usermanagement.resource.to.AddressResponse;
import com.microservicestutorial.usermanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/addresses")
public class AddressRestService {

    private final AddressService addressService;

    @Autowired
    public AddressRestService(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/")
    AddressResponse createAddress(@RequestBody AddressRequest addressRequest){
        return addressService.createAddress(addressRequest);
    }

    @Transactional
    @PutMapping("/{id}")
    AddressResponse updateAddress(@RequestBody AddressRequest addressRequest,
                                  @PathVariable Long id){
        return addressService.updateAddress(addressRequest, id);
    }

    @GetMapping("/{id}")
    Address getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @GetMapping("/")
    List<Address> getAllAddresses(){
        return addressService.getAll();
    }

    @DeleteMapping("/{id}")
    AddressResponse deleteAddressById(@PathVariable Long id){
        return addressService.deleteAddressById(id);
    }


//    @GetMapping("/v1/address")
//    public ResponseEntity<List<Address>> findAllOrderByCountryAsc(){
//        return new ResponseEntity<>(addressService.findAllOrderByCountryAsc(), HttpStatus.OK);
//    }
//    @GetMapping("/v1/address/paged")
//    public ResponseEntity<Page<Address>> findAllPaged(Pageable pageRequest){
//        return new ResponseEntity<>(addressService.findAllPaged(pageRequest), HttpStatus.OK);
//    }
//    @GetMapping("/v1/address/country/{country}")
//    public ResponseEntity<Optional<List<Address>>> findAddressByCountry(@PathVariable("country") String country){
//        return new ResponseEntity<>(addressService.findAddressByCountry(country), HttpStatus.OK);
//    }
}
