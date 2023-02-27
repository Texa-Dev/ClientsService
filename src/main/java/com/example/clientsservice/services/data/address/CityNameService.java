package com.example.clientsservice.services.data.address;

import com.example.clientsservice.models.adress.CityName;

import java.util.ArrayList;

public interface CityNameService {
    void saveAll(ArrayList<CityName> cityNames);

    CityName getReferenceById(int i);
}
