package com.example.clientsservice.services;

import com.example.clientsservice.models.User;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();
}
