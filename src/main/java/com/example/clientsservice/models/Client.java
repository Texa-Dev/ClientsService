package com.example.clientsservice.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//
@Entity
@Table(name = "clients")
public class Client {
    public enum Gender {
        NONE, MALE, FEMALE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50, nullable = false)
    private String surname;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 50, nullable = false)
    private String patronymic;
    private LocalDate birthDate;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private Gender gender;
    @OneToOne(optional = false) // тут не уверен, создает уникальность
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_address_id"))
    @ToString.Exclude
    private Address address;
    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private Set<Phone> phones;
    @ManyToMany
    @JoinTable(name ="clients_accounts",
            joinColumns = @JoinColumn(
                    table = "clients",
            referencedColumnName = "id",
            foreignKey =@ForeignKey(
                    name = "fk_client_id"
            )),
            inverseJoinColumns =
    @JoinColumn(table = "accounts",
            referencedColumnName ="id",
            foreignKey =@ForeignKey(
                    name = "fk_account_id")
    ))
    @ToString.Exclude
    private List<Account> accounts;

}
