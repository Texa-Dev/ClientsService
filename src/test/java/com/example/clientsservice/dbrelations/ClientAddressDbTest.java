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

@SpringBootTest
public class ClientAddressDbTest {

    @Qualifier(value = "clientServiceDb")
    @Autowired
    ClientService clientService;
    @Qualifier(value = "addressServiceDb")
    @Autowired
    AddressService addressService;

    static Client client = new Client(0, "s","n","p", LocalDate.now(),"E@t.ua", Client.Gender.MALE, null,null,null);
    static Address address = new Address(0,"12","45",null,null,null);

    @Test
    void save(){
        client = clientService.save(client);
        address=addressService.save(address);
        client.setAddress(address);
        System.out.println(client);
    }
}
