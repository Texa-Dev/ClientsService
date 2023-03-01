package com.example.clientsservice.services.data.address;

import com.example.clientsservice.models.adress.Street;
import com.example.clientsservice.models.adress.StreetName;

import java.util.ArrayList;
import java.util.List;

public interface StreetNameService {
    List<StreetName> saveAll(List<StreetName> streetNames);

    StreetName getReferenceById(int i);

    StreetName save(StreetName streetName);

    StreetName findByid(Integer id);

    List<StreetName> findAll();

    StreetName findByName(String streetName);

    void deleteById(Integer id);

    void deleteAll();
}
