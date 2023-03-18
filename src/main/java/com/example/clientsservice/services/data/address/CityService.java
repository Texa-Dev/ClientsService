package com.example.clientsservice.services.data.address;

import com.example.clientsservice.models.address.City;

import java.util.List;

public interface CityService {

    List<City> saveAll(List<City> cities);

    List<City> findAll();

    City getReferenceById(int i);

    City save(City city);

    City findById(Integer id);

    void deleteById(Integer id);

    void deleteAll();
}
