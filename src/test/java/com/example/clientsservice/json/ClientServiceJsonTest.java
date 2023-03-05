package com.example.clientsservice.json;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import com.example.clientsservice.services.data.qualifiers.QualifierClientServiceJson;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientServiceJsonTest {
    @QualifierClientServiceJson
    @Autowired
   private ClientService clientService;

    static Client testOne= new Client(1, "Surname", "Name", "Patronymic", LocalDate.now(),
                "email@test.com", Client.Gender.MALE, null, null, null);

   static List<Client> clients = List.of(new Client(1, "Surname", "Name", "Patronymic", LocalDate.now(),
                    "email@test.com", Client.Gender.MALE, null, null ,null ),
            new Client(2, "Surname1", "Name1", "Patronymic1", LocalDate.now(),
                    "email1@test.com", Client.Gender.MALE, null, null ,null ));
    @Test
    void saveAll(){

        clientService.saveAll(clients);
    }
    @Test
    void save(){

        clientService.save(testOne);
    }
    @Test
    void findAll(){

        List<Client> all = clientService.findAll();
        all.forEach(System.out::println);
    }
    @Test
    void findById(){

        System.out.println(clientService.findById(testOne.getId()));
    }
}
