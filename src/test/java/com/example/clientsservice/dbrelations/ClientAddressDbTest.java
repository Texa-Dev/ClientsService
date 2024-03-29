package com.example.clientsservice.dbrelations;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.AddressService;
import com.example.clientsservice.services.data.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class ClientAddressDbTest {

    @Qualifier(value = "clientServiceDb")
    @Autowired
    ClientService clientService;
    @Qualifier(value = "addressServiceDb")
    @Autowired
    AddressService addressService;


    @Test
    void save(){
        Random rnd = new Random();
        List<Address> allAddresses = addressService.findAll();
        List<Client> clients = clientService.findAll();

        for (Client client: clients) {
            Address address = allAddresses.get(rnd.nextInt(allAddresses.size()));
            client.setAddress(address);
            address.setClient(List.of(client));
        }
        clientService.saveAll(clients);
        addressService.saveAll(allAddresses);
    }
}
