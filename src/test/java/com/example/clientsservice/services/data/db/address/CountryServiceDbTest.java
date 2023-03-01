package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.Country;
import com.example.clientsservice.services.data.address.CountryService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CountryServiceDbTest {
    @Autowired
    CountryService countryService;

    static Country country = new Country(1, "Ukraine", null);
    static Country country1 = new Country(2, "Poland", null);

    static Country saved;
    static List<Country> countries;
    @Test
    @Order(1)
    void save(){
       saved = countryService.save(country1);
        assertNotNull(saved);
        assertEquals(saved,country1);
    }
    @Test
    @Order(2)
    void saveAll(){
        List<Country> savedAll = List.of(country, country1);
        countries = countryService.saveAll(savedAll);
        countries.forEach(System.out::println);
        assertNotNull(countries);
        assertEquals(savedAll,countries);
    }
    @Test
    @Order(3)
    void findById(){
       saved = countryService.findById(country1.getId());
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved,country1);

    }
    @Test
    @Order(4)
    void findByName(){
        saved = countryService.findByName(country.getCountry());
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved,country);

    }

    @Test
    @Order(4)
    void deleteById(){
       countryService.findAll().forEach(System.out::println);
        countryService.deleteById(country1.getId());
        assertNull(countryService.findById(country1.getId()));
        countryService.findAll().forEach(System.out::println);
    }
}
