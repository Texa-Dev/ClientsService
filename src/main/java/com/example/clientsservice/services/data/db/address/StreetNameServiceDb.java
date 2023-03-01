package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.StreetName;
import com.example.clientsservice.repositories.address.StreetNameRepository;
import com.example.clientsservice.services.data.address.StreetNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StreetNameServiceDb implements StreetNameService {
    @Autowired
    private StreetNameRepository streetNameRepository;

    @Override
    public List<StreetName> saveAll(List<StreetName> streetNames) {
        List<StreetName> list = streetNameRepository.saveAll(streetNames);
        return list.size() > 0 ? list : null;
    }

    @Override
    public StreetName getReferenceById(int i) {
        return streetNameRepository.getReferenceById(i);
    }

    @Override
    public StreetName save(StreetName streetName) {
        return streetNameRepository.save(streetName);
    }

    @Override
    public StreetName findByid(Integer id) {
        return streetNameRepository.findById(id).orElse(null);
    }

    @Override
    public List<StreetName> findAll() {
        List<StreetName> list = streetNameRepository.findAll();
        return list.size() > 0 ? list : null;
    }

    @Override
    public StreetName findByName(String streetName) {
        StreetName name = new StreetName();
        name.setStreetName(streetName);
        Example<StreetName> example = Example.of(name);
        return streetNameRepository.findBy(example, FluentQuery.FetchableFluentQuery::first).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        streetNameRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        streetNameRepository.deleteAll();
    }
}
