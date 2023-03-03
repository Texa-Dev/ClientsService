package com.example.clientsservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientsServiceApplicationTests {
    @Autowired
    ClientsServiceApplication application;

    @Test
    void contextLoads() {
      //  System.out.println(application);
    }

}
