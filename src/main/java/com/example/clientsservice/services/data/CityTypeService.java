package com.example.clientsservice.services.data;

import com.example.clientsservice.models.adress.CityType;

import java.util.ArrayList;

public interface CityTypeService {
    void saveAll(ArrayList<CityType> cityTypes);

    CityType getReferenceById(int i);
}
