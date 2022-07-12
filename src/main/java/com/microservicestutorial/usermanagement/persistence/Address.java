package com.microservicestutorial.usermanagement.persistence;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Parameter;


@Data
@Entity
@Table(name = "t_addresses")
public class Address {
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "addresses-sequence-generator")
    @GenericGenerator(
            name = "addresses-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "address_id_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
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
    @Column(name = "person_id")
    private Long personId;

    public Address() {
    }
}
