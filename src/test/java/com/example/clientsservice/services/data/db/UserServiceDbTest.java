package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.User;
import com.example.clientsservice.services.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class UserServiceDbTest {
    @Autowired
    UserService userService;

    @Autowired
    User userExp;
    User userAct;

    @Test
    @Order(1)
    void save() {
        userService.save(userExp);
        assertEquals(userExp, userAct);
    }
}
