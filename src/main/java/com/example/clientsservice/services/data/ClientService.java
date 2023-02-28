package com.example.clientsservice.services.data;

import com.example.clientsservice.models.Client;

import java.util.ArrayList;
import java.util.List;

public interface ClientService {
    Client save(Client client);
    Client findById(int id);

    void saveAll(ArrayList<Client> clients);

    List<Client> findAll();
}
