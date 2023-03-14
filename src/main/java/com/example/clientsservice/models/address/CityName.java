package com.example.clientsservice.models.address;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "cityName")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<City> city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityName cityName1 = (CityName) o;
        return Objects.equals(id, cityName1.id) && Objects.equals(cityName, cityName1.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityName);
    }
}
