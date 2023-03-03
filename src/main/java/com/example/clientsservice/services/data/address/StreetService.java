package com.example.clientsservice.services.data.address;

import com.example.clientsservice.models.adress.Street;

import java.util.List;

public interface StreetService {
    List<Street> saveAll(List<Street> streets);

    List<Street> findAll();

    Street getReferenceById(int i);

    Street save(Street street);

    Street findById(Integer id);

    void deleteById(Integer id);

    void deleteAll();
}
