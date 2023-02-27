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
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_streetTyp_id"))
    private StreetType streetType;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_streetName_id"))
    private StreetName streetName;
    @OneToOne(mappedBy = "street")
    private Address address;
}
