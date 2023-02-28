package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.repositories.ClientRepository;
import com.example.clientsservice.services.data.ClientService;
import com.example.clientsservice.services.data.qualifiers.QualifierClientServiceJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@QualifierClientServiceJson
public class ClientServiceDb implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findById(int id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public void saveAll(ArrayList<Client> clients) {
        clientRepository.saveAll(clients);
    }
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
