package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.services.data.AddressService;
import com.example.clientsservice.services.data.qualifiers.QualifierAddressServiceJson;
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
@QualifierAddressServiceJson
public class AddressServiceJson implements AddressService {
    @Autowired
    private Gson gson;
    private String fileName = "addresses.json";
    private String json;

    @Override
    public Address save(Address address) {
        json = gson.toJson(address);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Address> saveAll(List<Address> addresses) {
        json = gson.toJson(addresses);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Address findById(Integer id) {
        List<Address> all = findAll();
        return all.stream().filter(address -> Objects.equals(address.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        List<Address> all = findAll();
        all.removeIf(address -> Objects.equals(address.getId(), id));
        saveAll(all);
    }

    @Override
    public List<Address> findAll() {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(fileName));
            String json = new String(bytes);
            return gson.fromJson(json, new TypeToken<List<Address>>() {
            }.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAll() {
        List<Address> all = findAll();
        all.clear();
        saveAll(all);
    }
}
