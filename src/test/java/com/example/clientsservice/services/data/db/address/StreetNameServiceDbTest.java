package com.example.clientsservice.services.data.db.address;
import com.example.clientsservice.models.adress.StreetName;
import com.example.clientsservice.services.data.address.StreetNameService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StreetNameServiceDbTest {
    @Autowired
    StreetNameService streetNameService;
    static StreetName streetName=new StreetName(1, "Floral", null);
    static StreetName streetName1=new StreetName(2, "Spring", null);
    static StreetName streetName2=new StreetName(3, "Central", null);

    static StreetName saved;
    static List<StreetName> savedList;

    @Test
    @Order(1)
    void save() {
        saved = streetNameService.save(streetName);
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, streetName);
    }


    @Test
    @Order(2)
    void saveAll() {
        List<StreetName> savingList = List.of(streetName1, streetName2);
        savedList = streetNameService.saveAll(savingList);
        savedList.forEach(System.out::println);
        assertNotNull(savedList);
        assertEquals(savingList, savedList);
    }

    @Test
    @Order(3)
    void findById() {
        saved = streetNameService.findByid(streetName.getId());
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, streetName);
    }

    @Test
    @Order(4)
    void findAll() {
        savedList = streetNameService.findAll();
        savedList.forEach(System.out::println);
        assertNotNull(savedList);
        assertEquals(savedList, streetNameService.findAll());
    }

    @Test
    @Order(5)
    void findByName() {
        saved = streetNameService.findByName(streetName1.getStreetName());
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, streetNameService.findByName(streetName1.getStreetName()));
    }

    @Test
    @Order(6)
    void deleteById() {
        streetNameService.deleteById(streetName2.getId());
        assertNull(streetNameService.findByid(streetName2.getId()));
    }
    @Test
    @Order(7)
    void deleteAll() {
        streetNameService.deleteAll();
        assertNull(streetNameService.findAll());
    }

}
/*   ArrayList<StreetName> streetNames = new ArrayList<>();

        streetNames.add(new StreetName(0, "Floral", null));
        streetNames.add(new StreetName(0, "Spring", null));
        streetNames.add(new StreetName(0, "Sunny", null));
        streetNames.add(new StreetName(0, "Apricot", null));
        streetNames.add(new StreetName(0, "Garden", null));
        streetNames.add(new StreetName(0, "Meadow", null));
        streetNames.add(new StreetName(0, "Central", null));
        streetNames.add(new StreetName(0, "Harmony", null));
        streetNames.add(new StreetName(0, "Happiness", null));
        streetNames.add(new StreetName(0, "Lime", null));
        streetNames.add(new StreetName(0, "Rozhdestvenskaya", null));

        streetNameService.saveAll(streetNames);*/
