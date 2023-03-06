package com.example.clientsservice.services.data.json.addressjson;
import com.example.clientsservice.models.adress.StreetName;
import com.example.clientsservice.services.data.address.StreetNameService;
import com.example.clientsservice.services.data.qualifiers.addressqaulifiers.QualifierStreetNameServiceJson;
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
@QualifierStreetNameServiceJson
public class StreetNameServiceJson implements StreetNameService {
    @Autowired
    private Gson gson;
    private String fileName = "streetNames.json";
    private String json;

    @Override
    public List<StreetName> saveAll(List<StreetName> streetNames) {
        json = gson.toJson(streetNames);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StreetName getReferenceById(int i) {
        List<StreetName> all = findAll();
        return all.stream().filter(streetName -> Objects.equals(streetName.getId(), i)).findFirst().orElse(null);

    }

    @Override
    public StreetName save(StreetName streetName) {
        json = gson.toJson(streetName);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public StreetName findById(Integer id) {
        List<StreetName> all = findAll();
        return all.stream().filter(streetName -> Objects.equals(streetName.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public List<StreetName> findAll() {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(fileName));
            String json = new String(bytes);
            return gson.fromJson(json, new TypeToken<List<StreetName>>() {
            }.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public StreetName findByName(String streetName) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        List<StreetName> all = findAll();
       all.removeIf(streetName -> Objects.equals(streetName.getId(), id));
       saveAll(all);
    }

    @Override
    public void deleteAll() {
        List<StreetName> all = findAll();
        all.clear();
        saveAll(all);
    }
}
