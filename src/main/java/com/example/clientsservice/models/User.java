package com.example.clientsservice.models;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "users")
public class User {
    public enum Status {CREATED, ACTIVE, BLOCKED}
    public enum Role {ADMIN, USER, READER}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Integer id;
    @Column(nullable = false, unique = true)
    @NonNull
    private String username;
    @Column(nullable = false)
    @NonNull
    private String password;
    @Column(nullable = false, unique = true)
    @NonNull
    private String email;
    @Column(columnDefinition = "ENUM ('CREATED', 'ACTIVE', 'BLOCKED') default 'CREATED'")
    private Status status;
    @Column(columnDefinition = "ENUM ('ADMIN', 'USER', 'READER') default 'USER'")

    private Role role;
}
