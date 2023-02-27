package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.CityName;
import com.example.clientsservice.repositories.address.CityNameRepository;
import com.example.clientsservice.services.data.address.CityNameService;
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
