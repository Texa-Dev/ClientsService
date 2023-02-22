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
@Table(name = "regions")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false,unique = true)
    private String region;
    @OneToOne
    private Country country;
    @OneToOne(mappedBy = "region")
    private District district;
}
