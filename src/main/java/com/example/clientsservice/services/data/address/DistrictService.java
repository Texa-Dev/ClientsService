package com.example.clientsservice.services.data.address;

import com.example.clientsservice.models.adress.District;
import java.util.List;

public interface DistrictService {
    District save(District district);

    List<District> saveAll(List<District> districts);

    District getReferenceById(int i);

    District findById(Integer id);

    List<District> findAll();

    District findByName(String district);

    void deleteById(Integer id);

    void deleteAll();
}
