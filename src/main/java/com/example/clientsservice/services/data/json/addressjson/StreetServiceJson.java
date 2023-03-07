package com.example.clientsservice.services.data.json.addressjson;
import com.example.clientsservice.models.address.Street;
import com.example.clientsservice.services.data.address.StreetService;
import com.example.clientsservice.services.data.qualifiers.addressqaulifiers.QualifierStreetServiceJson;
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
@QualifierStreetServiceJson
public class StreetServiceJson implements StreetService {
    @Autowired
    private Gson gson;
    private String fileName = "streets.json";
    private String json;

    @Override
    public List<Street> saveAll(List<Street> streets) {
        json = gson.toJson(streets);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Street> findAll() {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(fileName));
            String json = new String(bytes);
            return gson.fromJson(json, new TypeToken<List<Street>>() {
            }.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Street getReferenceById(int i) {
        List<Street> all = findAll();
        return all.stream().filter(streetName -> Objects.equals(streetName.getId(), i)).findFirst().orElse(null);

    }

    @Override
    public Street save(Street street) {
        json = gson.toJson(street);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Street findById(Integer id) {
        List<Street> all = findAll();
        return all.stream().filter(streetName -> Objects.equals(streetName.getId(), id)).findFirst().orElse(null);

    }

    @Override
    public void deleteById(Integer id) {
        List<Street> all = findAll();
        all.removeIf(street -> Objects.equals(street.getId(), id));
        saveAll(all);
    }

    @Override
    public void deleteAll() {
        List<Street> all = findAll();
        all.clear();
        saveAll(all);
    }
}
