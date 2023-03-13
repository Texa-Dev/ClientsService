package com.example.clientsservice.dbrelations;

import com.example.clientsservice.models.address.CityName;
import com.example.clientsservice.services.data.address.CityNameService;
import com.example.clientsservice.services.data.address.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CityAndCityNameServiceTestDb {
    @Qualifier("cityNameServiceDb")
    @Autowired
    CityNameService cityNameService;

    @Qualifier("cityServiceDb")
    @Autowired
    CityService cityService;

    @Test
    void save() {
        cityNameService.findByName("Akhtyrka");
    }
}
