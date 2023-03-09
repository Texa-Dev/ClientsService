package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelSource {
    @Bean
    public User userInstance() {
        return new User();
    }
}
