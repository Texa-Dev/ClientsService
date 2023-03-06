package com.example.clientsservice.services.data.db.address;
import com.example.clientsservice.models.adress.District;
import com.example.clientsservice.services.data.address.DistrictService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DistrictServiceDbTest {
    @Autowired
    @Qualifier("districtServiceDb")
    DistrictService districtService;
    District district=new District(1, "Kremenchugsky", null, null);
    District district1=new District(2, "Poltavsky", null, null);
    District district2=new District(3, "Sumysky", null, null);

    District testOne;
    List<District> testList;

    @Test
    @Order(1)
    void save() {
        testOne = districtService.save(district);
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, district);
    }


    @Test
    @Order(2)
    void saveAll() {
        List<District> savingList = List.of(district1, district2);
        testList = districtService.saveAll(savingList);
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(savingList, testList);
    }

    @Test
    @Order(3)
    void findById() {
        testOne = districtService.findById(district.getId());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, district);
    }

    @Test
    @Order(4)
    void findAll() {
        testList = districtService.findAll();
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(testList, districtService.findAll());
    }

    @Test
    @Order(5)
    void findByName() {
        testOne = districtService.findByName(district1.getDistrict());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, districtService.findByName(district1.getDistrict()));
    }

    @Test
    @Order(6)
    void deleteById() {
        districtService.deleteById(district2.getId());
        assertNull(districtService.findById(district2.getId()));
    }

    @Test
    @Order(7)
    void deleteAll() {
        districtService.deleteAll();
        assertNull(districtService.findAll());
    }
}

/*

        ArrayList<District> districts = new ArrayList<>();
        districts.add(new District(0, "Kremenchugsky", regionService.getReferenceById(17), null));
        districts.add(new District(0, "Lubensky", regionService.getReferenceById(17), null));
        districts.add(new District(0, "Mirgorodsky", regionService.getReferenceById(17), null));
        districts.add(new District(0, "Poltavsky", regionService.getReferenceById(17), null));
        districts.add(new District(0, "Akhtyrsky", regionService.getReferenceById(19), null));
        districts.add(new District(0, "Konotopsky", regionService.getReferenceById(19), null));
        districts.add(new District(0, "Romensky", regionService.getReferenceById(19), null));
        districts.add(new District(0, "Sumysky", regionService.getReferenceById(19), null));
        districts.add(new District(0, "Shostkinsky", regionService.getReferenceById(19), null));

        districtService.saveAll(districts);*/