package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.CityName;
import com.example.clientsservice.repositories.address.CityNameRepository;
import com.example.clientsservice.services.data.address.CityNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityNameServiceDb implements CityNameService {
    @Autowired
    private CityNameRepository cityNameRepository;

    @Override
    public List<CityName> saveAll(List<CityName> cityNames) {
        List<CityName> list = cityNameRepository.saveAll(cityNames);
        return list.size() > 0 ? list : null;
    }

    @Override
    public CityName getReferenceById(int i) {

        return cityNameRepository.findById(i).orElse(null);
    }

    @Override
    public CityName save(CityName cityName) {
        return cityNameRepository.save(cityName);
    }

    @Override
    public CityName findById(Integer id) {
        return cityNameRepository.findById(id).orElse(null);
    }

    @Override
    public List<CityName> findAll() {
        List<CityName> list = cityNameRepository.findAll();
        return list.size() > 0 ? list : null;
    }

    @Override
    public CityName findByName(String cityName) {
        CityName name = new CityName();
        name.setCityName(cityName);
        Example<CityName> example = Example.of(name);
        return cityNameRepository.findBy(example, FluentQuery.FetchableFluentQuery::first).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        cityNameRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        cityNameRepository.deleteAll();
    }
}
