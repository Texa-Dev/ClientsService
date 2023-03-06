package com.example.clientsservice.services.data.json.addressjson;

import com.example.clientsservice.models.adress.Region;
import com.example.clientsservice.services.data.address.RegionService;
import com.example.clientsservice.services.data.qualifiers.addressqaulifiers.QualifierRegionServiceJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

@Service
@QualifierRegionServiceJson
public class RegionServiceJson implements RegionService {
    @Autowired
    private Gson gson;
    private String fileName = "regions.json";
    private String json;

    @Override
    public Region save(Region region) {
        json = gson.toJson(region);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Region> saveAll(List<Region> regions) {
        json = gson.toJson(regions);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Region getReferenceById(int i) {
        List<Region> all = findAll();
        for (Region region : all) {
            if (Objects.equals(region.getId(), i)) {
                return region;
            }
        }
        return null;
    }

    @Override
    public List<Region> findAll() {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(fileName));
            String json = new String(bytes);
            return gson.fromJson(json, new TypeToken<List<Region>>() {
            }.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Region findById(Integer id) {
        List<Region> all = findAll();
        for (Region region : all) {
            if (Objects.equals(region.getId(), id)) {
                return region;
            }
        }
        return null;
    }

    @Override
    public Region findByName(String region) {
        List<Region> all = findAll();
        return all.stream().filter(reg -> reg.getRegion().equals(region))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        List<Region> all = findAll();
        all.removeIf(region -> Objects.equals(region.getId(), id));
        saveAll(all);
    }

    @Override
    public void deleteAll() {
        List<Region> all = findAll();
        all.clear();
        saveAll(all);
    }
}
