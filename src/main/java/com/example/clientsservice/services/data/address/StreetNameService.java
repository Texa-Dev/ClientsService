package com.example.clientsservice.services.data.address;

import com.example.clientsservice.models.adress.Street;
import com.example.clientsservice.models.adress.StreetName;

import java.util.ArrayList;

public interface StreetNameService {
    void saveAll(ArrayList<StreetName> streetNames);

    StreetName getReferenceById(int i);
}
