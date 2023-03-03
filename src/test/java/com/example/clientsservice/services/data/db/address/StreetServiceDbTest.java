package com.example.clientsservice.services.data.db.address;
import com.example.clientsservice.models.adress.Street;
import com.example.clientsservice.services.data.address.StreetService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StreetServiceDbTest {
    @Autowired
    StreetService streetService;

    Street street = new Street(1, Street.StreetType.STREET,null,null);
    Street street1 = new Street(2, Street.StreetType.AVENUE,null,null);
    Street street2 = new Street(3, Street.StreetType.COURT,null,null);

     static Street testOne;
    static List<Street> testList;

    @Test
    @Order(1)
    void save() {
        testOne = streetService.save(street);
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, street);
    }


    @Test
    @Order(2)
    void saveAll() {
        List<Street> savingList = List.of(street1, street2);
        testList = streetService.saveAll(savingList);
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(savingList, testList);
    }

    @Test
    @Order(3)
    void findById() {
        testOne = streetService.findById(street.getId());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, street);
    }

    @Test
    @Order(4)
    void findAll() {
        testList = streetService.findAll();
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(testList, streetService.findAll());
    }


    @Test
    @Order(6)
    void deleteById() {
        streetService.deleteById(street2.getId());
        assertNull(streetService.findById(street2.getId()));
    }
    @Test
    @Order(7)
    void deleteAll() {
        streetService.deleteAll();
        assertNull(streetService.findAll());
    }
}
