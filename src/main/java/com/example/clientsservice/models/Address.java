package com.example.clientsservice.models;
import com.example.clientsservice.models.adress.City;
import com.example.clientsservice.models.adress.Street;
import lombok.*;
import javax.persistence.*;

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
    @OneToOne(mappedBy = "address")
    @ToString.Exclude
    private Client client;
    @OneToOne
    @ToString.Exclude
    private City city;
    @OneToOne
    @ToString.Exclude
    private Street street;

}
