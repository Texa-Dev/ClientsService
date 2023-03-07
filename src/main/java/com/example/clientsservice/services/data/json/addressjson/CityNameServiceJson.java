package com.example.clientsservice.services.data.json.addressjson;

import com.example.clientsservice.models.address.CityName;
import com.example.clientsservice.services.data.address.CityNameService;
import com.example.clientsservice.services.data.qualifiers.addressqaulifiers.QualifierCityNameServiceJson;
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
@QualifierCityNameServiceJson
public class CityNameServiceJson implements CityNameService {
    @Autowired
    private Gson gson;
    private String fileName = "cityNames.json";
    private String json;

    @Override
    public List<CityName> saveAll(List<CityName> cityNames) {
        json = gson.toJson(cityNames);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CityName getReferenceById(int i) {
        List<CityName> all = findAll();
        for (CityName cityName : all) {
            if (Objects.equals(cityName.getId(), i)) {
                return cityName;
            }
        }
        return null;
    }

    @Override
    public CityName save(CityName cityName) {
        json = gson.toJson(cityName);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CityName findById(Integer id) {
        List<CityName> all = findAll();
        for (CityName cityName : all) {
            if (Objects.equals(cityName.getId(), id)) {
                return cityName;
            }
        }
        return null;
    }

    @Override
    public List<CityName> findAll() {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(fileName));
            String json = new String(bytes);
            return gson.fromJson(json, new TypeToken<List<CityName>>() {
            }.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CityName findByName(String cityName) {
        List<CityName> all = findAll();
        return all.stream().filter(cityN -> cityN.getCityName().equals(cityName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        List<CityName> all = findAll();
        all.removeIf(cityName -> Objects.equals(cityName.getId(), id));
        saveAll(all);
    }

    @Override
    public void deleteAll() {
        List<CityName> all = findAll();
        all.clear();
        saveAll(all);
    }
}
