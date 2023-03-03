package com.example.clientsservice.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private Gender gender;
    @ManyToOne//(optional = false) // тут не уверен, создает уникальность
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_address_id"))
    @ToString.Exclude
   // @EqualsAndHashCode.Exclude
    private Address address;
    @OneToMany(mappedBy = "client")
    @ToString.Exclude
   // @EqualsAndHashCode.Exclude
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
   // @EqualsAndHashCode.Exclude
    private List<Account> accounts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(surname, client.surname) && Objects.equals(name, client.name) && Objects.equals(patronymic, client.patronymic) && Objects.equals(birthDate, client.birthDate) && Objects.equals(email, client.email) && gender == client.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic, birthDate, email, gender);
    }
}
