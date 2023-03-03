package com.example.clientsservice.models;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
//
@Entity
@Table(name = "phones")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false, length = 13)
    private String phone;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_phoneClient_id"))
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Client client;
}
