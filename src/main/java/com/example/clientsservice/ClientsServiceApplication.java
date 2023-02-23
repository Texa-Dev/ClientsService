package com.example.clientsservice;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;

@SpringBootApplication
public class ClientsServiceApplication {
    @Autowired
    private ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(ClientsServiceApplication.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void onLoaded() {
        Client client=new Client(0, "Surname", "Name", "Patronymic", LocalDate.now(),
                "email@test.com", Client.Gender.MALE, null, null ,null );
       client= clientRepository.save(client);
        System.out.println(client);
    }

}
