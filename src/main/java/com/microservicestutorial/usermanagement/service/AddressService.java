package com.microservicestutorial.usermanagement.service;

import com.microservicestutorial.usermanagement.persistence.Address;
import com.microservicestutorial.usermanagement.persistence.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public Address updateAddress(Address newAddress){
        Optional<Address> addressToUpdate = addressRepository.findById(newAddress.getAddressId());
        if(addressToUpdate.isPresent()) {
            Address _address = addressToUpdate.get();

            _address.setStreet(newAddress.getStreet());
            _address.setCity(newAddress.getCity());
            _address.setCountry(newAddress.getCountry());

            return addressRepository.save(_address);
        }
        return null;
    }

    public Optional<Address> findByAddressId(Long id){
        return Optional.ofNullable(addressRepository.findByAddressId(id));
    }

    public List<Address> findAllOrderByCountryAsc(){
        return addressRepository.findAll(Sort.by("country"));
    }

    public Optional<List<Address>> findAddressByCountry(String country){
        return Optional.ofNullable(addressRepository.findByCountry(country));
    }

    public void deleteAddressByAddressId(Long id){
        addressRepository.deleteAddressByAddressId(id);
    }

    public Page<Address> findAllPaged(Pageable pageRequest){
        Pageable pageParams = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize());
        return addressRepository.findAll(pageParams);
    }

}
