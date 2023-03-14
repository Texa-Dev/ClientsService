package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.address.City;
import com.example.clientsservice.models.address.CityName;
import com.example.clientsservice.models.address.District;
import com.example.clientsservice.services.data.address.CityNameService;
import com.example.clientsservice.services.data.address.CityService;
import com.example.clientsservice.services.data.address.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CityController {
    @Autowired
    @Qualifier("cityServiceDb")
    CityService cityService;
    @Autowired
    @Qualifier("cityNameServiceDb")
    CityNameService cityNameService;

    @Autowired
    @Qualifier("districtServiceDb")
    DistrictService districtService;

    @GetMapping("districtCities")
    public String load(Model model, @RequestParam("id") Integer id) {
        List<City> cities = districtService.findById(id).getCity();
        model.addAttribute("cities", cities).addAttribute("id", id);
        return "districtCities";
    }

    @PostMapping("addNewCity")
    ModelAndView addNewDistrict(@RequestParam("cityName") String cityName,
                                @RequestParam("cityType") City.CityType cityType,
                                @RequestParam("id") Integer id) {
        District district = districtService.findById(id);

        CityName byName = cityNameService.findByName(cityName);

        if (byName == null) {
            byName = cityNameService.save(new CityName(0, cityName, null));
        }


        City city = new City(0, cityType, district, byName, null);
        City finalCity = city;

        List<City> all = cityService.findAll();
        if (all!=null) {
            if(all.stream().anyMatch(c->c.equals(finalCity))) {
                return new ModelAndView("redirect:districtCities",
                        new ModelMap("id", id));
            }
        }
        city = cityService.save(city);


        if (byName.getCity() == null) {
            byName.setCity(new ArrayList<>(List.of(city)));
        } else {
            List<City> citiesBySameName = byName.getCity();
            citiesBySameName.add(city);
            byName.setCity(citiesBySameName);
        }

        cityNameService.save(byName);

         if (district.getCity() == null) {
            district.setCity(new ArrayList<>(List.of(city)));
        } else {
            List<City> citiesByDistrict = district.getCity();
            citiesByDistrict.add(city);
            district.setCity(citiesByDistrict);
        }
        districtService.save(district);

        return new ModelAndView("redirect:districtCities",
                new ModelMap("id", id));
    }
}
