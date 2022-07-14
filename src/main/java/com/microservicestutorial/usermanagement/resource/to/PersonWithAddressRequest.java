package com.microservicestutorial.usermanagement.resource.to;

import java.util.List;

public class PersonWithAddressRequest {
    private PersonRequest personRequest;
    private List<AddressWithinPersonRequest> addressWithinPersonRequestList;

    public PersonRequest getPersonRequest() {
        return personRequest;
    }

    public void setPersonRequest(PersonRequest personRequest) {
        this.personRequest = personRequest;
    }

    public List<AddressWithinPersonRequest> getAddressWithinPersonRequestList() {
        return addressWithinPersonRequestList;
    }

    public void setAddressWithinPersonRequestList(List<AddressWithinPersonRequest> addressWithinPersonRequestList) {
        this.addressWithinPersonRequestList = addressWithinPersonRequestList;
    }
}
