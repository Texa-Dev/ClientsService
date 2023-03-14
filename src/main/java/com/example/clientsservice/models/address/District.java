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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district1 = (District) o;
        return Objects.equals(id, district1.id) && Objects.equals(district, district1.district) && Objects.equals(region, district1.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, district, region);
    }
}
