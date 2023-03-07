package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.address.City;
import com.example.clientsservice.repositories.address.CityRepository;
import com.example.clientsservice.services.data.address.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceDb implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> saveAll(List<City> cities) {
        List<City> list = cityRepository.saveAll(cities);
        return list.size() > 0 ? list : null;
    }

    @Override
    public List<City> findAll() {
        List<City> list = cityRepository.findAll();
        return list.size() > 0 ? list : null;
    }

    @Override
    public City getReferenceById(int i) {
        return cityRepository.getReferenceById(i);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City findById(Integer id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        cityRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cityRepository.deleteAll();
    }


}
