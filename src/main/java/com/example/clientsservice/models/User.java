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
    {
        status=Status.CREATED;
        role=Role.USER;
    }
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
    @Column(nullable = false,
            columnDefinition = "int(1) default 2"
          //  columnDefinition = "ENUM ('CREATED', 'ACTIVE', 'BLOCKED') default 'CREATED'"
    )
    private Status status;
    @Column(nullable = false,
           // columnDefinition = "ENUM ('ADMIN', 'USER', 'READER') default 'USER'"
           columnDefinition = "int(1) default 0"
    )
    private Role role;
}
