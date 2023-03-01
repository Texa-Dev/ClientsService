package com.example.clientsservice.models.adress;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
//
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false, unique = true)
    private String country;
    @OneToMany(mappedBy =  "country")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Region> region;

}
