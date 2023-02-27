package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.adress.Street;
import com.example.clientsservice.models.adress.StreetName;
import com.example.clientsservice.repositories.StreetRepository;
import com.example.clientsservice.services.data.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StreetServiceDb implements StreetService {
    @Autowired
    private StreetRepository streetRepository;

    @Override
    public void saveAll(ArrayList<Street> streets) {
        streetRepository.saveAll(streets);
    }
}
