package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.Street;
import com.example.clientsservice.repositories.address.StreetRepository;
import com.example.clientsservice.services.data.address.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StreetServiceDb implements StreetService {
    @Autowired
    private StreetRepository streetRepository;

    @Override
    public void saveAll(ArrayList<Street> streets) {
        streetRepository.saveAll(streets);
    }

    @Override
    public List<Street> findAll() {
        return streetRepository.findAll();
    }
}
