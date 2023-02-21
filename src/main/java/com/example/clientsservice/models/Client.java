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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String surname;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String patronymic;
    private LocalDate birthDate;
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @OneToOne
    private Address address;
    @OneToMany
    private Set<Phone> phones;



}
