package com.example.clientsservice.models.address;

import com.example.clientsservice.models.Address;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
//
@Entity
@Table(name = "cities")
public class City {
  public  enum CityType{
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
    @EqualsAndHashCode.Exclude
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_district_id"))
    private District district;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_cityName_id"))
    private CityName cityName;

    @OneToOne(mappedBy = "city")
    @EqualsAndHashCode.Exclude
    private Address address;
}
