package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.Country;
import com.example.clientsservice.repositories.address.CountryRepository;
import com.example.clientsservice.services.data.address.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
    public Country findByName(String name) {
        Country con = new Country();
        con.setCountry(name);
        Example<Country> example = Example.of(con);
        return countryRepository.findBy(example, query -> query.first()).get();
        /*    default List<User> findByFirstNameAndAge(String firstName, int age) {
        User user = new User();
        user.setFirstName(firstName);
        user.setAge(age);
        Example<User> example = Example.of(user);
        return findBy(example, query -> query.fetch());
    }*/
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
