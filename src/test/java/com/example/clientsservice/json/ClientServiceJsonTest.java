package com.example.clientsservice.json;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import com.example.clientsservice.services.data.qualifiers.QualifierClientServiceJson;
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
public class ClientServiceJsonTest {
    @QualifierClientServiceJson
    @Autowired
    private ClientService clientService;

    static Client client = new Client(1, "White", "Walter", "Hartwell", LocalDate.of(1958,9,7),
            "email@test1.com", Client.Gender.MALE, null, null, null);
    static Client client2 = new Client(2, "Pinkman", "Jesse", "Bruce", LocalDate.of(1982,4,15),
            "email@test2.com", Client.Gender.MALE, null, null, null);
    static Client client3 = new Client(3, "Goodman", "Saul", "Morgan", LocalDate.of(1960,11,12),
            "email@test3.com", Client.Gender.FEMALE, null, null, null);

    static  Client testOne;
    static List<Client> testList;

    @Test
    @Order(1)
    void save() {
        testOne = clientService.save(client);
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, client);
    }

    @Test
    @Order(2)
    void saveAll() {
        List<Client> saving = List.of(client2,client3);
        testList = clientService.saveAll(saving);
        assertNotNull(testList);
        assertEquals(testList, saving);
    }

    @Test
    @Order(3)
    void findAll() {
        testList = clientService.findAll();
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(testList, clientService.findAll());
    }

    @Test
    @Order(4)
    void findById() {
       testOne= clientService.findById(client2.getId());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, client2);
    }

    @Test
    @Order(5)
    void deleteById() {
        clientService.deleteById(3);
        assertNull(clientService.findById(client.getId()));
        clientService.findAll().forEach(System.out::println);
    }

    @Test
    @Order(6)
    void deleteAll() {
        // clientService.findAll().forEach(System.out::println);
        clientService.deleteAll();
        assertNull(clientService.findAll());
    }
}
