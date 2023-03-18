package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.address.*;
import com.example.clientsservice.repositories.AddressRepository;
import com.example.clientsservice.services.data.AddressService;
import com.example.clientsservice.services.data.ClientService;
import com.example.clientsservice.services.data.address.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class ClientUpdateController {
    @Autowired
    @Qualifier(value = "clientServiceDb")
    ClientService clientService;

    @Autowired
    @Qualifier("addressServiceDb")
    AddressService addressService;
    @Autowired
    @Qualifier(value = "countryServiceDb")
    CountryService countryService;
    @Autowired
    @Qualifier(value = "regionServiceDb")
    RegionService regionService;
    @Autowired
    @Qualifier(value = "districtServiceDb")
    DistrictService districtService;
    @Autowired
    @Qualifier(value = "cityNameServiceDb")
    CityNameService cityNameService;
    @Autowired
    @Qualifier(value = "cityServiceDb")
    CityService cityService;

    @Autowired
    @Qualifier(value = "streetNameServiceDb")
    StreetNameService streetNameService;
    @Autowired
    @Qualifier(value = "streetServiceDb")
    StreetService streetService;


    @GetMapping("clientUpdate")
    public String load(Model model, @RequestParam("id") Integer id) {
        Client client = clientService.findById(id);
        if (client.getAddress() != null) {
            Address address = addressService.findById(client.getAddress().getId());
            model.addAttribute("client", client).addAttribute("address", address);
            return "clientUpdate";
        }
        model.addAttribute("client", client).addAttribute("address", null);
        return "clientUpdate";
    }

    @PostMapping("clientUpdateForm")
    public String clientUpdateForm(@ModelAttribute Client client, @RequestParam("address") Integer id,
                                   @RequestParam("country") String country,
                                   @RequestParam("region") String region,
                                   @RequestParam("district") String district,
                                   @RequestParam("cityName") String cityName,
                                   @RequestParam("cityType") City.CityType cityType,
                                   @RequestParam("streetName") String streetName,
                                   @RequestParam("streetType") Street.StreetType streetType,
                                   @RequestParam("house") String house,
                                   @RequestParam("apartment") String apartment
    ) {

            Country countryByName = countryService.findByName(country) != null ?
                    countryService.findByName(country) :
                    countryService.save(new Country(0, country, null));
            Region regionByName = regionService.findByName(region) != null ?
                    regionService.findByName(region) :
                    regionService.save(new Region(0, region, countryByName, null));
           /* countryByName.setRegion(List.of(regionByName));
            countryService.save(countryByName);*/
            District districtByName = districtService.findByName(district) != null ?
                    districtService.findByName(district) :
                    districtService.save(new District(0, district, regionByName, null));
            // regionByName.setDistrict(List.of(districtByName));
            // regionService.save(regionByName);

            CityName cityNameByName = cityNameService.findByName(cityName) != null ?
                    cityNameService.findByName(cityName) :
                    cityNameService.save(new CityName(0, cityName, null));

            City city = new City(0, cityType, districtByName, cityNameByName, null);
            city = cityService.save(city);

            StreetName streetNameByName = streetNameService.findByName(streetName) != null ?
                    streetNameService.findByName(streetName) :
                    streetNameService.save(new StreetName(0, streetName, null));

            Street street = new Street(0, streetType, streetNameByName, null);
            street = streetService.save(street);


            Address newAddress = new Address(0, house, apartment, List.of(client), city, street);
            newAddress = addressService.save(newAddress);
        System.out.println(newAddress.getId());
        if (id == 0) {
            client.setAddress(newAddress);
        } else {

            if (client.getAddress().equals(newAddress)){
                clientService.save(client);
            }else {
                client.setAddress(newAddress);
            }
        }

        clientService.save(client);
        return "redirect:clients";
    }
}

