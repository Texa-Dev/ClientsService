package com.example.clientsservice.models;

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
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,columnDefinition = "int default 0")
    private double amount;
    @ManyToMany(mappedBy = "accounts")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Client> clients;
}
