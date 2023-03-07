package com.example.clientsservice.dbrelations;

import com.example.clientsservice.models.address.Country;
import com.example.clientsservice.models.address.Region;
import com.example.clientsservice.services.data.address.CountryService;
import com.example.clientsservice.services.data.address.RegionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CountryRegionDbTest {
    @Qualifier(value = "countryServiceDb")
    @Autowired
    CountryService countryService;
    @Qualifier(value = "regionServiceDb")
    @Autowired
    RegionService regionService;
    @Test
    void save() {
        Country country = countryService.findByName("Ukraine");
        country.setRegion(regionService.findAll());
        List<Region> all = regionService.findAll();
        for (Region region : all) {
            region.setCountry(country);
        }
        countryService.save(country);
        regionService.saveAll(all);
    }
}
