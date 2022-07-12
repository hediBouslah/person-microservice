package com.microservicestutorial.usermanagement.service;

import com.microservicestutorial.usermanagement.exception.TechnicalException;
import com.microservicestutorial.usermanagement.persistence.Address;
import com.microservicestutorial.usermanagement.persistence.AddressRepository;
import com.microservicestutorial.usermanagement.resource.mapper.AddressMapper;
import com.microservicestutorial.usermanagement.resource.to.AddressRequest;
import com.microservicestutorial.usermanagement.resource.to.AddressResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressResponse createAddress(AddressRequest addressRequest) {
        Address addressEntity = AddressMapper.MapToAddressEntity(addressRequest);
        try {
            addressRepository.save(addressEntity);
        } catch (Exception e) {
            throw new TechnicalException("CAN NOT CREATE ADDRESS");
        }

        return AddressMapper.MapToAddressResponse(addressEntity);
    }

    public AddressResponse updateAddress(AddressRequest addressRequest, Long id) {
        Address existingAddress = getAddressById(id);

        existingAddress.setStreet(addressRequest.getStreet());
        existingAddress.setCity(addressRequest.getCity());
        existingAddress.setCountry(addressRequest.getCountry());
        if (addressRequest.getPersonId() != null)
            existingAddress.setPersonId(addressRequest.getPersonId());

        addressRepository.save(existingAddress);

        return AddressMapper.MapToAddressResponse(existingAddress);
    }

    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElseThrow(() -> new TechnicalException("Address Not Found"));
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public AddressResponse deleteAddressById(Long id) {
        AddressResponse addressResponse = AddressMapper.MapToAddressResponse(getAddressById(id));
        addressRepository.deleteById(id);
        return addressResponse;
    }

//    public List<Address> findAllOrderByCountryAsc(){
//        return addressRepository.findAll(Sort.by("country"));
//    }
//
//    public Optional<List<Address>> findAddressByCountry(String country){
//        return Optional.ofNullable(addressRepository.findByCountry(country));
//    }
//
//    public Page<Address> findAllPaged(Pageable pageRequest){
//        Pageable pageParams = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize());
//        return addressRepository.findAll(pageParams);
//    }
}
