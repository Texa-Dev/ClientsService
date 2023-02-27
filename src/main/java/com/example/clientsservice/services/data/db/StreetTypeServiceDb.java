package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.adress.StreetType;
import com.example.clientsservice.repositories.StreetTypeRepository;
import com.example.clientsservice.services.data.StreetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StreetTypeServiceDb implements StreetTypeService {
    @Autowired
    private StreetTypeRepository streetTypeRepository;

    @Override
    public void saveAll(ArrayList<StreetType> streetTypes) {
        streetTypeRepository.saveAll(streetTypes);
    }

    @Override
    public StreetType getReferenceById(int i) {
        return streetTypeRepository.getReferenceById(i);
    }
}
