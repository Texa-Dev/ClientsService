package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.User;
import com.example.clientsservice.repositories.UserRepository;
import com.example.clientsservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDb implements UserService {
@Autowired
    UserRepository userRepository;
    @Override
    public User save(User userExp) {
        return userRepository.save(userExp);
    }
}
