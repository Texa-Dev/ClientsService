package com.example.clientsservice.models;
import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String houseNumber;
    @Column(length = 4, nullable = false)
    private Integer flatNumber;
    @OneToOne(mappedBy = "address")
    private Client client;
    @OneToOne
    private City city;
    @OneToOne
    private Street street;

}
