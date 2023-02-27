package com.example.clientsservice.models.adress;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//
@Entity
@Table(name = "street_names")
public class StreetName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false, unique = true)
    private String cityName;
    @OneToMany(mappedBy = "streetName")
    @ToString.Exclude
    private List<Street> street;;
}
