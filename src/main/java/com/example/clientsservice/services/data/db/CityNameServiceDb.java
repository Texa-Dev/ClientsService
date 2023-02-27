package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.adress.CityName;
import com.example.clientsservice.repositories.CityNameRepository;
import com.example.clientsservice.services.data.CityNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CityNameServiceDb implements CityNameService {
    @Autowired
    private CityNameRepository cityNameRepository;
    @Override
    public void saveAll(ArrayList<CityName> cityNames) {
        cityNameRepository.saveAll(cityNames);
    }

    @Override
    public CityName getReferenceById(int i) {
        return cityNameRepository.getReferenceById(i);
    }
}
