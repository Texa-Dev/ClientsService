package com.example.clientsservice.repositories;

import com.example.clientsservice.models.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(@NonNull String username);
}
