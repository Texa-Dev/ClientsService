package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.adress.StreetName;
import com.example.clientsservice.repositories.StreetNameRepository;
import com.example.clientsservice.services.data.StreetNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StreetNameServiceDb implements StreetNameService {
    @Autowired
    private StreetNameRepository streetNameRepository;

    @Override
    public void saveAll(ArrayList<StreetName> streetNames) {
        streetNameRepository.saveAll(streetNames);
    }

    @Override
    public StreetName getReferenceById(int i) {
        return streetNameRepository.getReferenceById(i);
    }
}
