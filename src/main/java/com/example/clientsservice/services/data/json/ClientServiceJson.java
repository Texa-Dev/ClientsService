package com.example.clientsservice.services.data.json;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import com.example.clientsservice.services.data.qualifiers.QualifierClientServiceJson;
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
@QualifierClientServiceJson
public class ClientServiceJson implements ClientService {
    @Autowired
    private Gson gson;
    private String fileName = "clients.json";
    private String json;

    @Override
    public List<Client> saveAll(List<Client> clients) {
        json = gson.toJson(clients);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Client save(Client client) {
        json = gson.toJson(client);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Client findById(Integer id) {

        List<Client> all = findAll();
        for (Client client : all) {
            if(Objects.equals(client.getId(), id)){
                return client;
            }
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(fileName));
            String json = new String(bytes);
            return gson.fromJson(json, new TypeToken<List<Client>>() {
            }.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//TODO
    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteAll() {

    }
}
