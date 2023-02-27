package com.example.clientsservice.services.data;

import com.example.clientsservice.models.Address;

import java.util.ArrayList;

public interface AddressService {
    void saveAll(ArrayList<Address> addresses);
}
