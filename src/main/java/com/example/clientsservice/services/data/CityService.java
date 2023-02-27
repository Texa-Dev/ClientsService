package com.example.clientsservice.services.data;

import com.example.clientsservice.models.adress.City;

import java.util.ArrayList;
import java.util.List;

public interface CityService {
    void saveAll(ArrayList<City> cities);

 List<City> findAll();
}
