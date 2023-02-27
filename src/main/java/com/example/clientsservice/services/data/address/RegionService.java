package com.example.clientsservice.services.data.address;

import com.example.clientsservice.models.adress.Region;

import java.util.ArrayList;
import java.util.List;

public interface RegionService {
    Region save(Region region);
    void saveAll(ArrayList<Region> regions);
    Region getReferenceById(int i);

    List<Region> findAll();
}
