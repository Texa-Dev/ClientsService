package com.example.clientsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class ClientsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientsServiceApplication.class, args);

    }
}


