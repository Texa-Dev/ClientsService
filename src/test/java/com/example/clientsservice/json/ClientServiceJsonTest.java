package com.example.clientsservice.json;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceJsonTest {
    @Qualifier("clientServiceJson")
    @Autowired
   private ClientService clientService;

    @Test
    void saveAll(){
        List<Client> clients = List.of(new Client(0, "Surname", "Name", "Patronymic", LocalDate.now(),
                "email@test.com", Client.Gender.MALE, null, null ,null ),
                new Client(0, "Surname1", "Name1", "Patronymic1", LocalDate.now(),
                        "email1@test.com", Client.Gender.MALE, null, null ,null ));
        clientService.saveAll(clients);
    }
}
