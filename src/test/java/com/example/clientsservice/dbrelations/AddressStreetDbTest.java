package com.example.clientsservice.dbrelations;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.address.Street;
import com.example.clientsservice.services.data.AddressService;
import com.example.clientsservice.services.data.address.StreetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class AddressStreetDbTest {
    @Autowired
    @Qualifier("addressServiceDb")
    AddressService addressService;
    @Autowired
    @Qualifier("streetServiceDb")
    StreetService streetService;

    @Test
   // @Transactional
    void save(){
        Random rnd = new Random();
        List<Address> allAddresses = addressService.findAll();
        List<Street> allStreets = streetService.findAll();

        for (Address oneAddress : allAddresses) {
            Street street = allStreets.get(rnd.nextInt(allStreets.size()));
            oneAddress.setStreet(street);
            //TODO разобраться с List<Address> сохранением адрессов на одной улице
          /*  if (street.getAddress()==null){
                street.setAddress(new ArrayList<>(List.of(oneAddress)));
            }else{
                List<Address> address = street.getAddress();
                address.add(oneAddress);
                street.setAddress(address);
            }*/
        }
        addressService.saveAll(allAddresses);
        streetService.saveAll(allStreets);


    }

}
