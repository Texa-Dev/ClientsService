package com.example.clientsservice.models.adress;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    @ManyToOne
    private Country country;
    @OneToMany(mappedBy = "region")
    @ToString.Exclude
    private List<District> district;
}
