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
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CountryServiceDbTest {
    @Autowired
    CountryService countryService;

    static Country country = new Country(1, "Ukraine", null);
    static Country country1 = new Country(2, "Poland", null);
    static Country country2 = new Country(3, "Germany", null);

    static Country saved;
    static List<Country> countries;

    @Test
    @Order(1)
    void save() {
        saved = countryService.save(country);
        assertNotNull(saved);
        assertEquals(saved, country);
        System.out.println(saved);
    }

    @Test
    @Order(2)
    void saveAll() {
        List<Country> savedAll = List.of(country1, country2);
        countries = countryService.saveAll(savedAll);
        countries.forEach(System.out::println);
        assertNotNull(countries);
        assertEquals(savedAll, countries);
    }

    @Test
    @Order(3)
    void findById() {
        saved = countryService.findById(country1.getId());
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, country1);

    }

    @Test
    @Order(4)
    void findByName() {
        saved = countryService.findByName(country.getCountry());
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, country);

    }

    @Test
    @Order(5)
    void deleteById() {
        countryService.findAll().forEach(System.out::println);
        countryService.deleteById(country1.getId());
        assertNull(countryService.findById(country1.getId()));
        countryService.findAll().forEach(System.out::println);
    }

    @Test
    @Order(6)
    void deleteAll() {
        countryService.findAll().forEach(System.out::println);
        countryService.deleteAll();
        assertNull(countryService.findAll());
        System.out.println(countryService.findAll());
    }
}
//Countries example
/*
    Country country = new Country(0, "Ukraine", null);
        countryService.save(country);

                ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country(0, "Poland", null));
        countries.add(new Country(0, "Germany", null));
        countries.add(new Country(0, "USA", null));
        countries.add(new Country(0, "Switzerland", null));
        countries.add(new Country(0, "Italy", null));
        countries.add(new Country(0, "France", null));
        countries.add(new Country(0, "Austria", null));

        countryService.saveAll(countries);
*/