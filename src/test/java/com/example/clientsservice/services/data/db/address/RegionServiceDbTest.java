package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.address.Region;
import com.example.clientsservice.services.data.address.RegionService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RegionServiceDbTest {
    @Autowired
    @Qualifier("regionServiceDb")
    RegionService regionService;

    static Region region = new Region(1, "Cherkasy", null, null);
    static Region region1 = new Region(2, "Chernihiv", null, null);
    static Region region2 = new Region(3, "Kharkiv", null, null);

    static Region testOne;
    static List<Region> testList;

    @Test
    @Order(1)
    void save() {
        testOne = regionService.save(region);
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, region);
    }

    @Test
    @Order(2)
    void saveAll() {
        List<Region> savingList = List.of(region1, region2);
        testList = regionService.saveAll(savingList);
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(savingList, testList);
    }

    @Test
    @Order(3)
    void findById() {
        testOne = regionService.findById(region.getId());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, region);
    }

    @Test
    @Order(4)
    void findAll() {
        testList = regionService.findAll();
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(testList, regionService.findAll());
    }

    @Test
    @Order(5)
    void findByName() {
        testOne = regionService.findByName(region1.getRegion());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, regionService.findByName(region1.getRegion()));
    }

    @Test
    @Order(6)
    void deleteById() {
        regionService.deleteById(region2.getId());
        assertNull(regionService.findById(region2.getId()));
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
