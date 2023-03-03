package com.example.clientsservice.services.data.db.address;

import com.example.clientsservice.models.adress.Street;
import com.example.clientsservice.repositories.address.StreetRepository;
import com.example.clientsservice.services.data.address.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceDb implements StreetService {
    @Autowired
    private StreetRepository streetRepository;

    @Override
    public List<Street> saveAll(List<Street> streets) {
        return streetRepository.saveAll(streets);
    }

    @Override
    public List<Street> findAll() {
        List<Street> list = streetRepository.findAll();
        return list.size() > 0 ? list : null;
    }

    @Override
    public Street getReferenceById(int i) {
        return streetRepository.getReferenceById(i);
    }

    @Override
    public Street save(Street street) {
        return streetRepository.save(street);
    }

    @Override
    public Street findById(Integer id) {
        return streetRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        streetRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        streetRepository.deleteAll();
    }
}
