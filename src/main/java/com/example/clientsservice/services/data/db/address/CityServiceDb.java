package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.City;
import com.example.clientsservice.repositories.address.CityRepository;
import com.example.clientsservice.services.data.address.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceDb implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public void saveAll(ArrayList<City> cities) {
        cityRepository.saveAll(cities);
    }
    @Override
    public List<City> findAll() {
        City c = new City();
       // cityRepository.findAll();
      return cityRepository.findAll(Example.of(c));
    }

    @Override
    public City getReferenceById(int i) {
        return cityRepository.getReferenceById(i);
    }
}
