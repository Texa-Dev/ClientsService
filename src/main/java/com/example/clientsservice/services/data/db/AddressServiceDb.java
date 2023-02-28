package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.repositories.AddressRepository;
import com.example.clientsservice.services.data.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AddressServiceDb implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }
    @Override
    public void saveAll(ArrayList<Address> addresses) {
        addressRepository.saveAll(addresses);
    }

    @Override
    public Address getById(int i) {
        return addressRepository.getReferenceById(i);
    }
}
