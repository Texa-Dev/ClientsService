package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.User;
import com.example.clientsservice.services.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class UserServiceDbTest {
    @Autowired
    UserService userService;

    @Autowired
    User userExp;
    User userAct;
    @Autowired
    List<User> userList;

    @Test
    @Order(1)
    void save() {
        System.out.println(userExp);
        userAct = userService.save(userExp);
        assertEquals(userExp, userAct);
    }

    @Test
    @Order(1)
    void findAll() {
        userList = userService.findAll();
        assertEquals(userList, userService.findAll());
    }
}
