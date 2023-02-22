package com.example.clientsservice.models.adress;

import com.example.clientsservice.models.Address;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private District district;
    @OneToOne
    private CityType cityType;
    @OneToOne
    private CityName cityName;

    @OneToOne(mappedBy = "city")
    private Address address;
}
