package com.example.clientsservice.models.address;

import com.example.clientsservice.models.Address;
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
@Table(name = "streets")
public class Street {
    public enum StreetType{
        STREET,
        AVENUE,
        DRIVE,
        COURT,
        LANE,
        ALLEY
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private StreetType streetType;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_streetName_id"))
    private StreetName streetName;
    @OneToMany(mappedBy = "street")
    @EqualsAndHashCode.Exclude
    private List<Address> address;
}
