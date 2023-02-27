package com.example.clientsservice.services.data;

import com.example.clientsservice.models.adress.StreetType;

import java.util.ArrayList;

public interface StreetTypeService {
    void saveAll(ArrayList<StreetType> streetTypes);

    StreetType getReferenceById(int i);
}
