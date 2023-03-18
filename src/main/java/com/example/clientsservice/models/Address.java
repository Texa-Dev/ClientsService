package com.example.clientsservice.models;
import com.example.clientsservice.models.address.City;
import com.example.clientsservice.models.address.Street;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(house, address.house) && Objects.equals(apartment, address.apartment) && Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, house, apartment, city, street);
    }
}
