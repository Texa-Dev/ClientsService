package com.example.clientsservice.services.data.address;

import com.example.clientsservice.models.adress.Street;

import java.util.ArrayList;
import java.util.List;

public interface StreetService {
    void saveAll(ArrayList<Street> streets);

    List<Street> findAll();

    Street getReferenceById(int i);
}
