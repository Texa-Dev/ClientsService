package com.example.clientsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ClientsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientsServiceApplication.class, args);
/*
    @EventListener(ApplicationReadyEvent.class)
    public void onLoaded() {

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client(0, "Surname", "Name", "Patronymic", LocalDate.now(),
                "email@test.com", Client.Gender.MALE, addressService.getById(2), null, null));
        clients.add(new Client(0, "Surname1", "Name1", "Patronymic1", LocalDate.now(),
                "email1@test.com", Client.Gender.MALE, addressService.getById(2), null, null));
        clientService.saveAll(clients);

        System.out.println(clientService.findAll());

        */
    }
}


