package com.example.clientsservice.models;
import com.example.clientsservice.models.address.City;
import com.example.clientsservice.models.address.Street;
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
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String house;
    @Column(length = 4)
    private String apartment;
    @OneToMany(mappedBy = "address")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Client> client;
    @OneToOne
    @JoinColumn(foreignKey =  @ForeignKey(name = "fk_city_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private City city;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_street_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Street street;

}
