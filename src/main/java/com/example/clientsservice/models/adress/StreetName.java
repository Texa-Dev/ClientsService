package com.example.clientsservice.models.adress;

import lombok.*;

import javax.persistence.*;

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
    @OneToOne(mappedBy = "streetName")
    private Street street;;
}
