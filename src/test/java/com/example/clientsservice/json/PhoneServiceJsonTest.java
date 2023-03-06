package com.example.clientsservice.json;

import com.example.clientsservice.models.Phone;
import com.example.clientsservice.services.data.qualifiers.QualifierPhoneServiceJson;
import org.junit.jupiter.api.MethodOrderer;
import com.example.clientsservice.services.data.PhoneService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PhoneServiceJsonTest {

    @Autowired
    @QualifierPhoneServiceJson
    PhoneService phoneService;
    static Phone phone = new Phone(1, "+380508005038", null);
    static Phone phone1 = new Phone(2, "+38051234567", null);
    static Phone phone2 = new Phone(3, "+380679876543", null);

    static Phone testOne;
    static List<Phone> testList;

    @Test
    @Order(1)
    void save() {
        testOne = phoneService.save(phone);
        assertNotNull(testOne);
        assertEquals(testOne, phone);
        System.out.println(testOne);
    }

    @Test
    @Order(2)
    void saveAll() {
        List<Phone> savingList = List.of(phone1, phone2);
        testList = phoneService.saveAll(savingList);
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(savingList, testList);
    }

    @Test
    @Order(3)
    void findById() {
        testOne = phoneService.findById(phone1.getId());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, phone1);

    }

    @Test
    @Order(3)
    void findAll() {
        testList = phoneService.findAll();
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(testList, phoneService.findAll());

    }

    @Test
    @Order(4)
    void deleteById() {
        phoneService.deleteById(phone1.getId());
        assertNull(phoneService.findById(phone1.getId()));
        phoneService.findAll().forEach(System.out::println);
    }

    @Test
    @Order(5)
    void deleteAll() {
        // addressService.findAll().forEach(System.out::println);
        phoneService.deleteAll();
        assertNull(phoneService.findAll());
    }

}


