package com.example.clientsservice;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.adress.*;
import com.example.clientsservice.services.data.*;
import com.example.clientsservice.services.data.address.*;
import com.example.clientsservice.services.data.qualifiers.QualifierClientServiceJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class ClientsServiceApplication {
  /*  // @Qualifier("clientServiceDb")
    @Autowired
    // @QualifierClientServiceJson
    private ClientService clientService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private CityTypeService cityTypeService;
    @Autowired
    private CityNameService cityNameService;
    @Autowired
    private CityService cityService;
    @Autowired
    private StreetTypeService streetTypeService;
    @Autowired
    private StreetNameService streetNameService;
    @Autowired
    private StreetService streetService;
    @Autowired
    private AddressService addressService;
*/
    public static void main(String[] args) {
        SpringApplication.run(ClientsServiceApplication.class, args);
/*
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onLoaded() {




        ArrayList<City> cities = new ArrayList<>();
//towns
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(14), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(6), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(7), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(8), null));
        //cities
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(16), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(17), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(18), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(4), null));
        cities.add(new City(0, districtService.getReferenceById(4), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(19), null));

        cities.add(new City(0, districtService.getReferenceById(3), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(12), null));
        cities.add(new City(0, districtService.getReferenceById(3), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(1), null));
        cities.add(new City(0, districtService.getReferenceById(3), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(5), null));
        cities.add(new City(0, districtService.getReferenceById(3), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(10), null));

        cities.add(new City(0, districtService.getReferenceById(2), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(11), null));
        cities.add(new City(0, districtService.getReferenceById(2), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(13), null));
        cities.add(new City(0, districtService.getReferenceById(2), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(15), null));

        cities.add(new City(0, districtService.getReferenceById(1), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(9), null));
        cities.add(new City(0, districtService.getReferenceById(1), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(2), null));
        cities.add(new City(0, districtService.getReferenceById(1), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(3), null));

        cities.add(new City(0, districtService.getReferenceById(5), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(22), null));
        cities.add(new City(0, districtService.getReferenceById(5), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(27), null));

        cities.add(new City(0, districtService.getReferenceById(6), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(20), null));
        cities.add(new City(0, districtService.getReferenceById(6), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(26), null));

        cities.add(new City(0, districtService.getReferenceById(7), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(23), null));
        cities.add(new City(0, districtService.getReferenceById(7), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(33), null));
        cities.add(new City(0, districtService.getReferenceById(7), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(34), null));

        cities.add(new City(0, districtService.getReferenceById(8), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(35), null));
        cities.add(new City(0, districtService.getReferenceById(8), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(28), null));
        cities.add(new City(0, districtService.getReferenceById(8), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(25), null));

        cities.add(new City(0, districtService.getReferenceById(9), cityTypeService.getReferenceById(2),
                cityNameService.getReferenceById(21), null));
        cities.add(new City(0, districtService.getReferenceById(9), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(30), null));
        cities.add(new City(0, districtService.getReferenceById(9), cityTypeService.getReferenceById(3),
                cityNameService.getReferenceById(24), null));

        cityService.saveAll(cities);
        //   System.out.println(cityService.findAll());





        ArrayList<Street> streets = new ArrayList<>();

        streets.add(new Street(0, streetTypeService.getReferenceById(1), streetNameService.getReferenceById(1), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(2), streetNameService.getReferenceById(2), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(2), streetNameService.getReferenceById(4), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(3), streetNameService.getReferenceById(7), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(4), streetNameService.getReferenceById(4), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(5), streetNameService.getReferenceById(9), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(5), streetNameService.getReferenceById(8), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(6), streetNameService.getReferenceById(3), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(2), streetNameService.getReferenceById(1), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(6), streetNameService.getReferenceById(5), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(7), streetNameService.getReferenceById(6), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(4), streetNameService.getReferenceById(8), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(2), streetNameService.getReferenceById(1), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(4), streetNameService.getReferenceById(2), null));
        streets.add(new Street(0, streetTypeService.getReferenceById(3), streetNameService.getReferenceById(7), null));

        streetService.saveAll(streets);

        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(new Address(0, "10", "4", null, cityService.getReferenceById(1), streetService.getReferenceById(1)));
        addresses.add(new Address(0, "1", "5", null, cityService.getReferenceById(2), streetService.getReferenceById(2)));
        addresses.add(new Address(0, "2", "6", null, cityService.getReferenceById(3), streetService.getReferenceById(3)));
        addresses.add(new Address(0, "3", "7", null, cityService.getReferenceById(4), streetService.getReferenceById(4)));
        addresses.add(new Address(0, "5", "54", null, cityService.getReferenceById(5), streetService.getReferenceById(5)));
        addresses.add(new Address(0, "1123", "34", null, cityService.getReferenceById(6), streetService.getReferenceById(5)));
        addresses.add(new Address(0, "23", "34", null, cityService.getReferenceById(7), streetService.getReferenceById(6)));
        addresses.add(new Address(0, "546", "23", null, cityService.getReferenceById(8), streetService.getReferenceById(6)));
        addresses.add(new Address(0, "2", "12", null, cityService.getReferenceById(9), streetService.getReferenceById(7)));
        addresses.add(new Address(0, "56", "6", null, cityService.getReferenceById(10), streetService.getReferenceById(8)));
        addresses.add(new Address(0, "2", "54", null, cityService.getReferenceById(11), streetService.getReferenceById(9)));
        addresses.add(new Address(0, "4", "76", null, cityService.getReferenceById(2), streetService.getReferenceById(10)));
        addresses.add(new Address(0, "56", "72", null, cityService.getReferenceById(12), streetService.getReferenceById(11)));
        addresses.add(new Address(0, "123", "98", null, cityService.getReferenceById(11), streetService.getReferenceById(11)));
        addresses.add(new Address(0, "86", "122", null, cityService.getReferenceById(11), streetService.getReferenceById(12)));
        addresses.add(new Address(0, "43", "323", null, cityService.getReferenceById(14), streetService.getReferenceById(13)));
        addresses.add(new Address(0, "45", "45", null, cityService.getReferenceById(32), streetService.getReferenceById(14)));
        addresses.add(new Address(0, "65", "122", null, cityService.getReferenceById(12), streetService.getReferenceById(15)));
        addresses.add(new Address(0, "23", "657", null, cityService.getReferenceById(3), streetService.getReferenceById(4)));
        addresses.add(new Address(0, "5", "4", null, cityService.getReferenceById(4), streetService.getReferenceById(6)));

        addressService.saveAll(addresses);
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client(0, "Surname", "Name", "Patronymic", LocalDate.now(),
                "email@test.com", Client.Gender.MALE, addressService.getById(2), null, null));
        clients.add(new Client(0, "Surname1", "Name1", "Patronymic1", LocalDate.now(),
                "email1@test.com", Client.Gender.MALE, addressService.getById(2), null, null));
        clientService.saveAll(clients);

        System.out.println(clientService.findAll());
        *//**//*
        */
    }
}


