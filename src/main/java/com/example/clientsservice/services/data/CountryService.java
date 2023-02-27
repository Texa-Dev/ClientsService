package com.example.clientsservice.services.data;

import com.example.clientsservice.models.adress.Country;

import java.util.ArrayList;
import java.util.List;

public interface CountryService {
    Country save(Country country);

    void saveAll(ArrayList<Country> countries);

    Country getReferenceById(int i);

    List<Country> findAll();
}
