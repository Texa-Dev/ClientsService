package com.example.clientsservice.services.data.json.addressjson;

import com.example.clientsservice.models.adress.District;
import com.example.clientsservice.services.data.address.DistrictService;
import com.example.clientsservice.services.data.qualifiers.addressqaulifiers.QualifierDistrictServiceJson;
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
@QualifierDistrictServiceJson
public class DistrictServiceJson implements DistrictService {
     @Autowired
    private Gson gson;
    private String fileName = "districts.json";
    private String json;
    @Override
    public District save(District district) {
        json = gson.toJson(district);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<District> saveAll(List<District> districts) {
        json = gson.toJson(districts);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public District getReferenceById(int i) {
        List<District> all = findAll();
        for (District district : all) {
            if (Objects.equals(district.getId(), i)) {
                return district;
            }
        }
        return null;
    }

    @Override
    public List<District> findAll() {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(fileName));
            String json = new String(bytes);
            return gson.fromJson(json, new TypeToken<List<District>>() {
            }.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public District findById(Integer id) {
        List<District> all = findAll();
        for (District district : all) {
            if (Objects.equals(district.getId(), id)) {
                return district;
            }
        }
        return null;
    }

    @Override
    public District findByName(String district) {
        List<District> all = findAll();
        return all.stream().filter(reg -> reg.getDistrict().equals(district))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        List<District> all = findAll();
        all.removeIf(district -> Objects.equals(district.getId(), id));
        saveAll(all);
    }

    @Override
    public void deleteAll() {
        List<District> all = findAll();
        all.clear();
        saveAll(all);
    }
}
