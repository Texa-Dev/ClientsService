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
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false, unique = true)
    private String district;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_region_id"))
    private Region region;
    @OneToMany(mappedBy = "district")
    @ToString.Exclude
    private List<City> city;
}
