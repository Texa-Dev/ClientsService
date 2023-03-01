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
  private  enum CityType{
        CAPITAL,
        TOWN,
        CITY,
        VILLAGE
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private CityType cityType;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_district_id"))
    private District district;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_cityName_id"))
    private CityName cityName;

    @OneToOne(mappedBy = "city")
    private Address address;
}
