package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceDbTest {
    @Autowired
    ClientService clientService;
    static Client client = new Client(1, "Surname", "Name", "Patronymic", LocalDate.now(),
            "email@test.com", Client.Gender.MALE, null, null, null);
static  Client saved;
static List<Client> clients;
    @Test
    @Order(1)
    void save() {
         saved = clientService.save(client);
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, client);
    }

    @Test
    @Order(2)
    void findById() {
        saved = clientService.findById(client.getId());
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, client);
    }

    @Test
    @Order(2)
    void findAll() {
        clients=clientService.findAll();
        clients.forEach(System.out::println);
        assertEquals(clients, clientService.findAll());
    }
}
