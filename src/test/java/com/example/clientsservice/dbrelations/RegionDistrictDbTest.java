package com.example.clientsservice.dbrelations;

import com.example.clientsservice.models.address.District;
import com.example.clientsservice.models.address.Region;
import com.example.clientsservice.services.data.address.DistrictService;
import com.example.clientsservice.services.data.address.RegionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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

        List<District> poltavaDist = new ArrayList<>(regionPol.getDistrict());
        for (District district : poltavaDist) {
            district.setRegion(regionPol);
        }
        regionSum.setDistrict(List.of(districtService.findByName("Sumysky")));

        List<District> sumyDist = regionSum.getDistrict();
        for (District district : sumyDist) {
            district.setRegion(regionSum);
        }

        poltavaDist.addAll(sumyDist);
        districtService.saveAll(poltavaDist);
        regionService.saveAll(List.of(regionPol, regionSum));
    }
}
