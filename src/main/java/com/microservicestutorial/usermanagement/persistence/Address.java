package com.microservicestutorial.usermanagement.persistence;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "t_addresses")
public class Address {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    @Column(name = "street")
    @NotBlank
    private String street;
    @Column(name = "city")
    @NotBlank
    private String city;
    @Column(name = "country")
    @NotNull
    private String country;

    public Address() {
    }
}
