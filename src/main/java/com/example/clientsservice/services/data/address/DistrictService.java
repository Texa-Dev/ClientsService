package com.example.clientsservice.services.data.address;

import com.example.clientsservice.models.adress.District;
import com.example.clientsservice.models.adress.Region;

import java.util.ArrayList;
import java.util.List;

public interface DistrictService {
    District save(District district);

    List<District> saveAll(List<District> districts);

    District getReferenceById(int i);

    District findByid(Integer id);

    List<District> findAll();

    District findByName(String district);

    void deleteById(Integer id);

    void deleteAll();
}
