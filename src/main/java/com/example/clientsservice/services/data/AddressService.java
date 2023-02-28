package com.example.clientsservice.services.data;

import com.example.clientsservice.models.Address;

import java.util.ArrayList;

public interface AddressService {
    void save(Address address);

    void saveAll(ArrayList<Address> addresses);

    Address getById(int i);
}
