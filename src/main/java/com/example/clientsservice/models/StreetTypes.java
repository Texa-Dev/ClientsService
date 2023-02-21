package com.example.clientsservice.models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//
@Entity
@Table(name = "street_types")
public class StreetTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false, unique = true)
    private String streetType;
    @OneToOne(mappedBy = "streetType")
    private Street street;
}
