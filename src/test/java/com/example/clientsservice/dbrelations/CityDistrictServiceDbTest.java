package com.example.clientsservice.dbrelations;

import com.example.clientsservice.models.address.City;
import com.example.clientsservice.models.address.CityName;
import com.example.clientsservice.models.address.District;
import com.example.clientsservice.services.data.address.CityNameService;
import com.example.clientsservice.services.data.address.CityService;
import com.example.clientsservice.services.data.address.DistrictService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CityDistrictServiceDbTest {
    @Autowired
    @Qualifier("districtServiceDb")
    DistrictService districtService;

    @Autowired
    @Qualifier("cityServiceDb")
    CityService cityService;

    @Qualifier("cityNameServiceDb")
    @Autowired
    CityNameService cityNameService;
    @Test
    void save(){
        District district = districtService.findByName("Akhtyrsky");
        CityName cityName = cityNameService.findByName("Akhtyrka");
        City byId = cityService.findById(3);
        byId.setDistrict(district);
        byId.setCityName(cityName);
        byId =  cityService.save(byId);


        List<City> distCities = new ArrayList<>(district.getCity());
        distCities.add(byId);
        district.setCity(distCities);

        List<City> citiesBySameName = cityName.getCity();
        citiesBySameName.add(byId);
        cityName.setCity(citiesBySameName);


        cityNameService.save(cityName);
        districtService.save(district);

    }
}
