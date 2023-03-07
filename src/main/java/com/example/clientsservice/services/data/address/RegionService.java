package com.example.clientsservice.services.data.address;

import com.example.clientsservice.models.address.Region;

import java.util.List;

public interface RegionService {
    Region save(Region region);
    List<Region> saveAll(List<Region> regions);
    Region getReferenceById(int i);

    List<Region> findAll();

    Region findById(Integer id);

    Region findByName(String region);

    void deleteById(Integer id);

    void deleteAll();
}
