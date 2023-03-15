package com.example.clientsservice.dbrelations;

import com.example.clientsservice.models.address.Street;
import com.example.clientsservice.models.address.StreetName;
import com.example.clientsservice.services.data.address.StreetNameService;
import com.example.clientsservice.services.data.address.StreetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StreetAndStreetNameDbTest {
    @Autowired
    @Qualifier("streetNameServiceDb")
    StreetNameService streetNameService;
    @Autowired
    @Qualifier("streetServiceDb")
    StreetService streetService;

    @Test
    void save(){
        List<StreetName> allStreetNames = streetNameService.findAll();
        List<Street> allStreets = streetService.findAll();
        for (int i = 0; i < allStreets.size(); i++) {
            allStreets.get(i).setStreetName(allStreetNames.get(i));
            allStreetNames.get(i).setStreet(List.of(allStreets.get(i)));
        }
        streetNameService.saveAll(allStreetNames);
        streetService.saveAll(allStreets);
    }

}
