package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.adress.Country;
import com.example.clientsservice.repositories.CountryRepository;
import com.example.clientsservice.services.data.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceDb implements CountryService {
@Autowired
private CountryRepository countryRepository;
    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void saveAll(ArrayList<Country> countries) {
        countryRepository.saveAll(countries);
    }

    @Override
    public Country getReferenceById(int i) {
        return countryRepository.getReferenceById(i);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
