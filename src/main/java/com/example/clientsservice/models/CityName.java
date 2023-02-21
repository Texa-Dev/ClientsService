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
@Table(name = "city_names")
public class CityName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false,unique = true)
    private String cityName;

    @OneToOne(mappedBy = "cityName")
    private City city;
}
