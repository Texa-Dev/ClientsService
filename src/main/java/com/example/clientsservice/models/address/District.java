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
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false, unique = true)
    private String district;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_region_id"))
    @EqualsAndHashCode.Exclude
    private Region region;
    @OneToMany(mappedBy = "district")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<City> city;
}
