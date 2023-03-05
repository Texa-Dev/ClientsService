package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.adress.Country;
import com.example.clientsservice.services.data.address.CountryService;
import com.example.clientsservice.services.data.qualifiers.QualifierCountryServiceJson;
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
@QualifierCountryServiceJson
public class CountryServiceJson implements CountryService {
    @Autowired
    private Gson gson;
    private String fileName = "countries.json";
    private String json;
    @Override
    public Country save(Country country) {
        json = gson.toJson(country);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Country> saveAll(List<Country> countries) {
        json = gson.toJson(countries);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Country findById(int i) {
        List<Country> all = findAll();
        for (Country country : all) {
            if(Objects.equals(country.getId(), i)){
                return country;
            }
        }
        return null;
    }

    @Override
    public Country getReferenceById(int i) {
        List<Country> all = findAll();
        for (Country country : all) {
            if(Objects.equals(country.getId(), i)){
                return country;
            }
        }
        return null;
    }

    @Override
    public Country findByName(String name) {
        List<Country> all = findAll();
        for (Country country : all) {
            if(Objects.equals(country.getCountry(), name)){
                return country;
            }
        }
        return null;
    }

    @Override
    public List<Country> findAll() {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(fileName));
            String json = new String(bytes);
            return gson.fromJson(json, new TypeToken<List<Country>>() {
            }.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int i) {

    }

    @Override
    public void deleteAll() {

    }
}
