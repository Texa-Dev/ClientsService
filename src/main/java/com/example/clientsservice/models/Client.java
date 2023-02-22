package com.example.clientsservice.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//
@Entity
@Table(name = "clients")
public class Client {
    public enum Gender {
        NONE, MALE, FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String surname;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String patronymic;
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private Gender gender;

    @OneToOne(optional = false)
    private Address address;
    @OneToMany
    private Set<Phone> phones;



}
