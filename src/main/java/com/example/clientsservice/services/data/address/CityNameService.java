package com.example.clientsservice.services.data.address;

import com.example.clientsservice.models.address.CityName;

import java.util.List;

public interface CityNameService {
    List<CityName> saveAll(List<CityName> cityNames);

    CityName getReferenceById(int i);

    CityName save(CityName cityName);

    CityName findById(Integer id);

    List<CityName> findAll();

    CityName findByName(String cityName);

    void deleteById(Integer id);

    void deleteAll();
}
