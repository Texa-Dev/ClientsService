package com.example.clientsservice.services.data;

import com.example.clientsservice.models.adress.District;

import java.util.ArrayList;

public interface DistrictService {
    District save(District district);

    void saveAll(ArrayList<District> districts);

    District getReferenceById(int i);
}
