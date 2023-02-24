package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.repositories.ClientRepository;
import com.example.clientsservice.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceDb implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }
}
