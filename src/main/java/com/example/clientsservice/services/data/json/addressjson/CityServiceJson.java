package com.example.clientsservice.services.data.json.addressjson;
import com.example.clientsservice.models.address.City;
import com.example.clientsservice.services.data.address.CityService;
import com.example.clientsservice.services.data.qualifiers.addressqaulifiers.QualifierCityServiceJson;
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
@QualifierCityServiceJson
public class CityServiceJson implements CityService {
    @Autowired
    private Gson gson;
    private String fileName = "cities.json";
    private String json;


    @Override
    public List<City> saveAll(List<City> cities) {
        json = gson.toJson(cities);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public City getReferenceById(int i) {
        List<City> all = findAll();
        for (City city : all) {
            if (Objects.equals(city.getId(), i)) {
                return city;
            }
        }
        return null;
    }

    @Override
    public City save(City city) {
        json = gson.toJson(city);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public City findById(Integer id) {
        List<City> all = findAll();
        for (City city : all) {
            if (Objects.equals(city.getId(), id)) {
                return city;
            }
        }
        return null;
    }

    @Override
    public List<City> findAll() {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(fileName));
            String json = new String(bytes);
            return gson.fromJson(json, new TypeToken<List<City>>() {
            }.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        List<City> all = findAll();
        all.removeIf(cityName -> Objects.equals(cityName.getId(), id));
        saveAll(all);
    }

    @Override
    public void deleteAll() {
        List<City> all = findAll();
        all.clear();
        saveAll(all);
    }
}
