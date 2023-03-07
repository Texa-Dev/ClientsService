package com.example.clientsservice.services.data.address;

import com.example.clientsservice.models.adress.Country;

import java.util.List;

public interface CountryService {
    Country save(Country country);

    List<Country> saveAll(List<Country> countries);

    Country findById(int i);

    Country getReferenceById(int i);

    Country findByName(String name);

    List<Country> findAll();

    void deleteById(int i);

    void deleteAll();

}
