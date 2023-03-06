package com.example.clientsservice.json;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.services.data.AddressService;
import com.example.clientsservice.services.data.qualifiers.QualifierAddressServiceJson;
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
public class AddressServiceJsonTest {

    @Autowired
    @QualifierAddressServiceJson
    AddressService addressService;

    static Address address = new Address(1, "10", "4", null, null, null);
    static Address address1 = new Address(2, "15a", "45", null, null, null);
    static Address address2 = new Address(3, "123", "5c", null, null, null);
    static Address testOne;
    static List<Address> testList;

    @Test
    @Order(1)
    void save() {
        testOne = addressService.save(address);
        assertNotNull(testOne);
        assertEquals(testOne, address);
        System.out.println(testOne);
    }

    @Test
    @Order(2)
    void saveAll() {
        List<Address> savingList = List.of(address1, address2);
        testList = addressService.saveAll(savingList);
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(savingList, testList);
    }

    @Test
    @Order(3)
    void findById() {
        testOne = addressService.findById(address1.getId());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, address1);

    }

    @Test
    @Order(3)
    void findAll() {
        testList = addressService.findAll();
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(testList, addressService.findAll());

    }

    @Test
    @Order(4)
    void deleteById() {
        addressService.deleteById(address1.getId());
        assertNull(addressService.findById(address1.getId()));
        addressService.findAll().forEach(System.out::println);
    }

    @Test
    @Order(5)
    void deleteAll() {
        // addressService.findAll().forEach(System.out::println);
        addressService.deleteAll();
        assertNull(addressService.findAll());
    }

}
/*
        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(new Address(0, "10", "4", null, cityService.getReferenceById(1), streetService.getReferenceById(1)));
        addresses.add(new Address(0, "1", "5", null, cityService.getReferenceById(2), streetService.getReferenceById(2)));
        addresses.add(new Address(0, "2", "6", null, cityService.getReferenceById(3), streetService.getReferenceById(3)));
        addresses.add(new Address(0, "3", "7", null, cityService.getReferenceById(4), streetService.getReferenceById(4)));
        addresses.add(new Address(0, "5", "54", null, cityService.getReferenceById(5), streetService.getReferenceById(5)));
        addresses.add(new Address(0, "1123", "34", null, cityService.getReferenceById(6), streetService.getReferenceById(5)));
        addresses.add(new Address(0, "23", "34", null, cityService.getReferenceById(7), streetService.getReferenceById(6)));
        addresses.add(new Address(0, "546", "23", null, cityService.getReferenceById(8), streetService.getReferenceById(6)));
        addresses.add(new Address(0, "2", "12", null, cityService.getReferenceById(9), streetService.getReferenceById(7)));
        addresses.add(new Address(0, "56", "6", null, cityService.getReferenceById(10), streetService.getReferenceById(8)));
        addresses.add(new Address(0, "2", "54", null, cityService.getReferenceById(11), streetService.getReferenceById(9)));
        addresses.add(new Address(0, "4", "76", null, cityService.getReferenceById(2), streetService.getReferenceById(10)));
        addresses.add(new Address(0, "56", "72", null, cityService.getReferenceById(12), streetService.getReferenceById(11)));
        addresses.add(new Address(0, "123", "98", null, cityService.getReferenceById(11), streetService.getReferenceById(11)));
        addresses.add(new Address(0, "86", "122", null, cityService.getReferenceById(11), streetService.getReferenceById(12)));
        addresses.add(new Address(0, "43", "323", null, cityService.getReferenceById(14), streetService.getReferenceById(13)));
        addresses.add(new Address(0, "45", "45", null, cityService.getReferenceById(32), streetService.getReferenceById(14)));
        addresses.add(new Address(0, "65", "122", null, cityService.getReferenceById(12), streetService.getReferenceById(15)));
        addresses.add(new Address(0, "23", "657", null, cityService.getReferenceById(3), streetService.getReferenceById(4)));
        addresses.add(new Address(0, "5", "4", null, cityService.getReferenceById(4), streetService.getReferenceById(6)));

        addressService.saveAll(addresses);*/


