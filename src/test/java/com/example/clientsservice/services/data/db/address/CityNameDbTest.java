package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.CityName;
import com.example.clientsservice.services.data.address.CityNameService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CityNameDbTest {
    @Autowired
    CityNameService cityNameService;
    static CityName cityName = new CityName(1, "Kremenchuk", null);
    static CityName cityName1 = new CityName(2, "Poltava", null);
    static CityName cityName2 = new CityName(3, "Akhtyrka", null);

    static CityName saved;
    static List<CityName> savedList;
@Test
    @Order(1)
    void save() {
        saved = cityNameService.save(cityName);
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, cityName);
    }


    @Test
    @Order(2)
    void saveAll() {
        List<CityName> savingList = List.of(cityName1, cityName2);
        savedList = cityNameService.saveAll(savingList);
        savedList.forEach(System.out::println);
        assertNotNull(savedList);
        assertEquals(savingList, savedList);
    }

    @Test
    @Order(3)
    void findById() {
        saved = cityNameService.findByid(cityName.getId());
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, cityName);
    }

    @Test
    @Order(4)
    void findAll() {
        savedList = cityNameService.findAll();
        savedList.forEach(System.out::println);
        assertNotNull(savedList);
        assertEquals(savedList, cityNameService.findAll());
    }

    @Test
    @Order(5)
    void findByName() {
        saved = cityNameService.findByName(cityName1.getCityName());
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, cityNameService.findByName(cityName1.getCityName()));
    }

    @Test
    @Order(6)
    void deleteById() {
        cityNameService.deleteById(cityName2.getId());
        assertNull(cityNameService.findByid(cityName2.getId()));
    }
    @Test
    @Order(7)
    void deleteAll() {
        cityNameService.deleteAll();
        assertNull(cityNameService.findAll());
    }

}
// City names example;
/*       ArrayList<CityName> cityNames = new ArrayList<>();

        cityNames.add(new CityName(0, "Gadyach", null));
        cityNames.add(new CityName(0, "Globino", null));
        cityNames.add(new CityName(0, "Horishni Plavni", null));
        cityNames.add(new CityName(0, "Grebyonka", null));
        cityNames.add(new CityName(0, "Zavodskoye", null));
        cityNames.add(new CityName(0, "Zenkov", null));
        cityNames.add(new CityName(0, "Karlovka", null));
        cityNames.add(new CityName(0, "Kobelyaki", null));
        cityNames.add(new CityName(0, "Kremenchuk", null));
        cityNames.add(new CityName(0, "Lokhvytsa", null));
        cityNames.add(new CityName(0, "Lubny", null));
        cityNames.add(new CityName(0, "Mirgorod", null));
        cityNames.add(new CityName(0, "Pyryatin", null));
        cityNames.add(new CityName(0, "Poltava", null));
        cityNames.add(new CityName(0, "Khorol", null));
        cityNames.add(new CityName(0, "Dikanka", null));
        cityNames.add(new CityName(0, "Kotelva", null));
        cityNames.add(new CityName(0, "New Sanzhary", null));
        cityNames.add(new CityName(0, "Opishna", null));
        cityNames.add(new CityName(0, "Konotop", null));
        cityNames.add(new CityName(0, "Shostka", null));
        cityNames.add(new CityName(0, "Akhtyrka", null));
        cityNames.add(new CityName(0, "Romny", null));
        cityNames.add(new CityName(0, "Glukhov", null));
        cityNames.add(new CityName(0, "Lebedin", null));
        cityNames.add(new CityName(0, "Krolevets", null));
        cityNames.add(new CityName(0, "Trostyanets", null));
        cityNames.add(new CityName(0, "Belopolye", null));
        cityNames.add(new CityName(0, "Krasnopole", null));
        cityNames.add(new CityName(0, "Seredina-Buda", null));
        cityNames.add(new CityName(0, "Voronezh", null));
        cityNames.add(new CityName(0, "Stepanovka", null));
        cityNames.add(new CityName(0, "Lipovaya Dolina", null));
        cityNames.add(new CityName(0, "Nedrigailov", null));
        cityNames.add(new CityName(0, "Sumy", null));

        cityNameService.saveAll(cityNames);*/
