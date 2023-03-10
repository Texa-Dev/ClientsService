package com.example.clientsservice.dbrelations;

import com.example.clientsservice.models.address.District;
import com.example.clientsservice.models.address.Region;
import com.example.clientsservice.services.data.address.DistrictService;
import com.example.clientsservice.services.data.address.RegionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

@SpringBootTest
public class RegionDistrictDbTest {
    @Qualifier(value = "regionServiceDb")
    @Autowired
    RegionService regionService;
    @Qualifier(value = "districtServiceDb")
    @Autowired
    DistrictService districtService;

    @Test
    void save() {
        Region regionPol = regionService.findByName("Poltava");
        Region regionSum = regionService.findByName("Sumy");
        regionPol.setDistrict(List.of(districtService.findByName("Kremenchugsky"),
                districtService.findByName("Poltavsky")));
        regionSum.setDistrict(List.of(districtService.findByName("Sumysky")));
        List<District> poltavaDist = regionPol.getDistrict();;
        for (District district : poltavaDist) {
            district.setRegion(regionPol);
        }
      /*  List<District> sumyDist = districtService.findAll().stream().
                filter(district -> Objects.equals(district.getRegion().getId(), regionSum.getId())).toList();
        for (District district : sumyDist) {
            district.setRegion(regionSum);
        }*/

       // poltavaDist.addAll(sumyDist);
        // System.out.println(poltavaDist);
        districtService.saveAll(poltavaDist);

        regionService.saveAll(List.of(regionPol, regionSum));

        Region regionPol1 = regionService.findByName("Poltava");
     /*   List<District> district = regionPol1.getDistrict();
        System.out.println(district);*/
      /*  countryService.save(country);
        regionService.saveAll(all);*/
    }
}
