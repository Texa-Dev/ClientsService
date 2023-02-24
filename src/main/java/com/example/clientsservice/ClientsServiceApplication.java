package com.example.clientsservice;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.adress.Country;
import com.example.clientsservice.models.adress.Region;
import com.example.clientsservice.repositories.ClientRepository;
import com.example.clientsservice.repositories.CountryRepository;
import com.example.clientsservice.services.data.ClientService;
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

    @Autowired
    private ClientService clientService;
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(ClientsServiceApplication.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void onLoaded() {
//        Client client=new Client(0, "Surname", "Name", "Patronymic", LocalDate.now(),
//                "email@test.com", Client.Gender.MALE,
//                null, null ,null );
//       client= clientService.save(client);
//        System.out.println(client);

        Country country=new Country(0,"Ukraine",new Region());
        country= countryRepository.save(country);
        System.out.println(country);
    }

}
