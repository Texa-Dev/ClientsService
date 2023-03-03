package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.repositories.AddressRepository;
import com.example.clientsservice.services.data.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceDb implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public List<Address> saveAll(List<Address> addresses) {
        List<Address> list = addressRepository.saveAll(addresses);
        return list.size() > 0 ? list : null;
    }

    @Override
    public Address findById(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<Address> findAll() {
        List<Address> list = addressRepository.findAll();
        return list.size() > 0 ? list : null;
    }

    @Override
    public void deleteAll() {
        addressRepository.deleteAll();
    }
}
