package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.address.CityName;
import com.example.clientsservice.services.data.address.CityNameService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CityNameDbTest {
    @Autowired
    @Qualifier("cityNameServiceDb")
    CityNameService cityNameService;
    static CityName cityName = new CityName(1, "Kremenchuk", null);
    static CityName cityName1 = new CityName(2, "Poltava", null);
    static CityName cityName2 = new CityName(3, "Akhtyrka", null);

    static CityName testOne;
    static List<CityName> testList;

    @Test
    @Order(1)
    void save() {
        testOne = cityNameService.save(cityName);
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, cityName);
    }


    @Test
    @Order(2)
    void saveAll() {
        List<CityName> savingList = List.of(cityName1, cityName2);
        testList = cityNameService.saveAll(savingList);
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(savingList, testList);
    }

    @Test
    @Order(3)
    void findById() {
        testOne = cityNameService.findById(cityName.getId());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, cityName);
    }

    @Test
    @Order(4)
    void findAll() {
        testList = cityNameService.findAll();
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(testList, cityNameService.findAll());
    }

    @Test
    @Order(5)
    void findByName() {
        testOne = cityNameService.findByName(cityName1.getCityName());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, cityNameService.findByName(cityName1.getCityName()));
    }

    @Test
    @Order(6)
    void deleteById() {
        cityNameService.deleteById(cityName2.getId());
        assertNull(cityNameService.findById(cityName2.getId()));
    }

    @Test
    @Order(7)
    void deleteAll() {
        cityNameService.deleteAll();
        assertNull(cityNameService.findAll());
    }

}
