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
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false, unique = true)
    private String district;
    @OneToOne
    private Region region;
    @OneToOne(mappedBy = "district")
    private City city;
}
