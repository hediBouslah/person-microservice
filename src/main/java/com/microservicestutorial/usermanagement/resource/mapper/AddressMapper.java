package com.microservicestutorial.usermanagement.resource.mapper;

import com.microservicestutorial.usermanagement.persistence.Address;
import com.microservicestutorial.usermanagement.resource.to.AddressRequest;
import com.microservicestutorial.usermanagement.resource.to.AddressResponse;

public class AddressMapper {
    public static Address MapToAddressEntity(AddressRequest addressRequest) {
        Address address = new Address();
        if (addressRequest.getId() != null) {
            address.setAddressId(addressRequest.getId());
        }
        address.setStreet(addressRequest.getStreet());
        address.setCity(addressRequest.getCity());
        address.setCountry(addressRequest.getCountry());
        address.setPersonId(addressRequest.getPersonId());

        return address;
    }

    public static AddressResponse MapToAddressResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setId(address.getAddressId());
        addressResponse.setStreet(address.getStreet());
        addressResponse.setCity(address.getCity());
        addressResponse.setCountry(address.getCountry());
        addressResponse.setPersonId(address.getPersonId());

        return addressResponse;
    }


}
