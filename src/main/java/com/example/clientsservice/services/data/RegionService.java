package com.example.clientsservice.services.data;

import com.example.clientsservice.models.adress.Region;

import java.util.ArrayList;

public interface RegionService {
    Region save(Region region);
    void saveAll(ArrayList<Region> regions);

    Region getReferenceById(int i);
}
