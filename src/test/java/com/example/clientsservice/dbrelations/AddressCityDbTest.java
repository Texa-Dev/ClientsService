package com.example.clientsservice.dbrelations;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.address.City;
import com.example.clientsservice.services.data.AddressService;
import com.example.clientsservice.services.data.address.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class AddressCityDbTest {
    @Autowired
    @Qualifier("addressServiceDb")
    AddressService addressService;
    @Autowired
    @Qualifier("cityServiceDb")
    CityService cityService;

    @Test
    void save(){
        Random rnd = new Random();
        List<Address> allAddresses = addressService.findAll();
        List<City> allCities = cityService.findAll();

        for (Address address : allAddresses) {
            City city = allCities.get(rnd.nextInt(allCities.size()));
            address.setCity(city);
        }
        addressService.saveAll(allAddresses);
    }
}
