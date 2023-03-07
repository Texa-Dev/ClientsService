package com.example.clientsservice.models.address;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
//
@Entity
@Table(name = "city_names")
public class CityName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false,unique = true)
    private String cityName;

    @OneToMany(mappedBy = "cityName")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<City> city;
}
