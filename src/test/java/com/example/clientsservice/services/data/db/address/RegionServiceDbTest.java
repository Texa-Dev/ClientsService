package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.Region;
import com.example.clientsservice.services.data.address.RegionService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegionServiceDbTest {
    @Autowired
    RegionService regionService;

    static Region region = new Region(1, "Cherkasy", null, null);
    static Region region1 = new Region(2, "Chernihiv", null, null);
    static Region region2 = new Region(3, "Kharkiv", null, null);

    static Region saved;
    static List<Region> savedList;

    @Test
    @Order(1)
    void save() {
        saved = regionService.save(region);
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, region);
    }

    @Test
    @Order(2)
    void saveAll() {
        List<Region> savingList = List.of(region1, region2);
        savedList = regionService.saveAll(savingList);
        savedList.forEach(System.out::println);
        assertNotNull(savedList);
        assertEquals(savingList, savedList);
    }

    @Test
    @Order(3)
    void findById() {
        saved = regionService.findByid(region.getId());
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, region);
    }

    @Test
    @Order(4)
    void findAll() {
        savedList = regionService.findAll();
        savedList.forEach(System.out::println);
        assertNotNull(savedList);
        assertEquals(savedList, regionService.findAll());
    }

    @Test
    @Order(5)
    void findByName() {
        saved = regionService.findByName(region1.getRegion());
        System.out.println(saved);
        assertNotNull(saved);
        assertEquals(saved, regionService.findByName(region1.getRegion()));
    }

    @Test
    @Order(6)
    void deleteById() {
        regionService.deleteById(region2.getId());
        assertNull(regionService.findByid(region2.getId()));
    }
    @Test
    @Order(7)
    void deleteAll() {
        regionService.deleteAll();
        assertNull(regionService.findAll());
    }


}

/*ArrayList<Region> regions = new ArrayList<>(Arrays.asList(

                (new Region(0, "Chernivtsi", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Crimea", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Dnipropetrovsk", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Donetsk", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Ivano-Frankivsk", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Kharkiv", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Kherson", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Khmelnytskyi", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Kirovohrad", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Kyiv", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Luhansk", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Lviv", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Mykolaiv", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Odesa", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Poltava", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Rivne", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Sumy", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Ternopil", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Vinnytsia", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Volyn", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Zakarpattia", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Zaporizhzhia", countryService.findByName("Ukraine"), null)),
                (new Region(0, "Zhytomyr", countryService.findByName("Ukraine"), null))

        ));
        regionService.saveAll(regions);*/
