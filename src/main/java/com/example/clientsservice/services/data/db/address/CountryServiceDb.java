package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.Country;
import com.example.clientsservice.repositories.address.CountryRepository;
import com.example.clientsservice.services.data.address.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CountryServiceDb implements CountryService {
@Autowired
private CountryRepository countryRepository;
    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public List<Country> saveAll(List<Country> countries) {
        return countryRepository.saveAll(countries);
    }

    @Override
    public Country getReferenceById(int i) {
        return countryRepository.getReferenceById(i);
    }

    @Override
    public Country findByName(String name) {
        Country con = new Country();
        con.setCountry(name);
        Example<Country> example = Example.of(con);
        return countryRepository.findBy(example, FluentQuery.FetchableFluentQuery::first).orElseThrow();
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(int i) {
        return countryRepository.findById(i).orElse(null);
    }

    @Override
    public void deleteById(int i) {
        countryRepository.deleteById(i);
    }
}
