package com.microservicestutorial.usermanagement.resource.to;

import java.util.List;

public class PersonWithAddressResponse {
    private PersonResponse personResponse;
    private List<AddressResponse> addressResponseList;

    public PersonResponse getPersonResponse() {
        return personResponse;
    }

    public void setPersonResponse(PersonResponse personResponse) {
        this.personResponse = personResponse;
    }

    public List<AddressResponse> getAddressResponseList() {
        return addressResponseList;
    }

    public void setAddressResponseList(List<AddressResponse> addressResponseList) {
        this.addressResponseList = addressResponseList;
    }
}
