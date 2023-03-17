package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class ModelSource {
    @Bean
    public User userInstance(BCryptPasswordEncoder encoder) {
        String pass = encoder.encode("admin");
        User user = new User(1, "admin", pass, "admin@mail.com");
        user.setStatus(User.Status.ACTIVE);
        user.setRole(User.Role.ADMIN);
        return user;
    }
}
