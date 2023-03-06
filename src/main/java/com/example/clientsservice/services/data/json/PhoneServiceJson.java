package com.example.clientsservice.services.data.json;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.services.data.PhoneService;
import com.example.clientsservice.services.data.qualifiers.QualifierPhoneServiceJson;
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
@QualifierPhoneServiceJson
public class PhoneServiceJson implements PhoneService {
    @Autowired
    private Gson gson;
    private String fileName = "phones.json";
    private String json;

    @Override
    public Phone save(Phone phone) {
        json = gson.toJson(phone);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phone;
    }

    @Override
    public List<Phone> saveAll(List<Phone> savingList) {
        json = gson.toJson(savingList);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return savingList.size()>0?savingList:null;
    }

    @Override
    public Phone findById(Integer id) {
        List<Phone> all = findAll();
        return all.stream().filter(client -> Objects.equals(client.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public List<Phone> findAll() {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(fileName));
            String json = new String(bytes);
            List<Phone> phones = gson.fromJson(json, new TypeToken<List<Phone>>() {
            }.getType());
            return phones.size()>0?phones:null;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        List<Phone> all = findAll();
        all.removeIf(client -> Objects.equals(client.getId(), id));
        saveAll(all);
    }

    @Override
    public void deleteAll() {
        List<Phone> all = findAll();
        all.clear();
        saveAll(all);
    }
}
