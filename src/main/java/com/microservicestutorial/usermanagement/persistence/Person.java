package com.microservicestutorial.usermanagement.persistence;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import org.hibernate.annotations.Parameter;

import java.util.Date;

@Data
@Entity
@Table(name = "t_persons")
public class Person {
    @Column(name = "id")
    @Id
    @GeneratedValue(generator = "persons-sequence-generator")
    @GenericGenerator(
            name = "persons-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "person_id_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private long personId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "department_id")
    private Long departmentId;

    public Person() {
    }
}

//@Data === @Getter && @Setter && @RequiredArgsConstructor && @ToString && @EqualsAndHashCode
