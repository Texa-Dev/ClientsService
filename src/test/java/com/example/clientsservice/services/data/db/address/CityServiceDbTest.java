package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.City;
import com.example.clientsservice.services.data.address.CityService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CityServiceDbTest {
    @Autowired
    @Qualifier("cityServiceDb")
    CityService cityService;
    City city = new City(1, City.CityType.CAPITAL, null,null,null);
    City city1 = new City(2, City.CityType.TOWN, null,null,null);
    City city2 = new City(3, City.CityType.CITY, null,null,null);

    City testOne;
    List<City> testList;

    @Test
    @Order(1)
    void save() {
        testOne = cityService.save(city);
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, city);
    }


    @Test
    @Order(2)
    void saveAll() {
        List<City> savingList = List.of(city1, city2);
        testList = cityService.saveAll(savingList);
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(savingList, testList);
    }

    @Test
    @Order(3)
    void findById() {
        testOne = cityService.findById(city.getId());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, city);
    }

    @Test
    @Order(4)
    void findAll() {
        testList = cityService.findAll();
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(testList, cityService.findAll());
    }
    @Test
    @Order(5)
    void deleteById() {
        cityService.deleteById(city2.getId());
        assertNull(cityService.findById(city2.getId()));
    }
    @Test
    @Order(6)
    void deleteAll() {
        cityService.deleteAll();
        assertNull(cityService.findAll());
    }
}



/* ArrayList<City> cities = new ArrayList<>();
//towns
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(14), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(6), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(7), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(8), null));
        //cities
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(16), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(17), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(18), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(4), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(19), null));

        cities.add(new City(0, districtService.getReferenceById(3), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(12), null));
        cities.add(new City(0, districtService.getReferenceById(3), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(1), null));
        cities.add(new City(0, districtService.getReferenceById(3), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(5), null));
        cities.add(new City(0, districtService.getReferenceById(3), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(10), null));

        cities.add(new City(0, districtService.getReferenceById(2), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(11), null));
        cities.add(new City(0, districtService.getReferenceById(2), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(13), null));
        cities.add(new City(0, districtService.getReferenceById(2), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(15), null));

        cities.add(new City(0, districtService.getReferenceById(1), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(9), null));
        cities.add(new City(0, districtService.getReferenceById(1), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(2), null));
        cities.add(new City(0, districtService.getReferenceById(1), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(3), null));

        cities.add(new City(0, districtService.getReferenceById(5), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(22), null));
        cities.add(new City(0, districtService.getReferenceById(5), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(27), null));

        cities.add(new City(0, districtService.getReferenceById(6), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(20), null));
        cities.add(new City(0, districtService.getReferenceById(6), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(26), null));

        cities.add(new City(0, districtService.getReferenceById(7), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(23), null));
        cities.add(new City(0, districtService.getReferenceById(7), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(33), null));
        cities.add(new City(0, districtService.getReferenceById(7), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(34), null));

        cities.add(new City(0, districtService.getReferenceById(8), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(35), null));
        cities.add(new City(0, districtService.getReferenceById(8), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(28), null));
        cities.add(new City(0, districtService.getReferenceById(8), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(25), null));

        cities.add(new City(0, districtService.getReferenceById(9), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(21), null));
        cities.add(new City(0, districtService.getReferenceById(9), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(30), null));
        cities.add(new City(0, districtService.getReferenceById(9), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(24), null));

        cityService.saveAll(cities);*/