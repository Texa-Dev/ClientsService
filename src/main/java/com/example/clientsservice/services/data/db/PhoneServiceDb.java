package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Phone;
import com.example.clientsservice.repositories.PhoneRepository;
import com.example.clientsservice.services.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceDb implements PhoneService {
    @Autowired
    PhoneRepository phoneRepository;

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public List<Phone> saveAll(List<Phone> savingList) {
        List<Phone> list = phoneRepository.saveAll(savingList);
        return list.size() > 0 ? list : null;
    }

    @Override
    public Phone findById(Integer id) {
        return phoneRepository.findById(id).orElse(null);
    }

    @Override
    public List<Phone> findAll() {
        List<Phone> list = phoneRepository.findAll();
        return list.size() > 0 ? list : null;
    }

    @Override
    public void deleteById(Integer id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        phoneRepository.deleteAll();
    }
}
