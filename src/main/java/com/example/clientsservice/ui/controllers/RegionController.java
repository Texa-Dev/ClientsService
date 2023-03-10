package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.address.Country;
import com.example.clientsservice.models.address.Region;
import com.example.clientsservice.services.data.address.CountryService;
import com.example.clientsservice.services.data.address.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class RegionController {
    @Qualifier(value = "regionServiceDb")
    @Autowired
    RegionService regionService;
    @Qualifier(value = "countryServiceDb")
    @Autowired
    CountryService countryService;


    @GetMapping("countryRegions")
    public String load(Model model, @RequestParam("id") Integer id) {
        List<Region> regions = countryService.findById(id).getRegion();
        /*  List<Region> regions = regionService.findAll().stream().
               filter(region -> Objects.equals(region.getCountry().getId(), id)).toList();*/
        model.addAttribute("regions", regions).addAttribute("country_id", id);
        return "countryRegions";
    }

    @PostMapping("addNewRegion")
    String addNewRegion(@ModelAttribute Region region, @RequestParam("country_id") Integer id) {
        Country country = countryService.findById(id);
        region.setCountry(country);
        List<Region> regions = country.getRegion();
        regions.add(region);
        country.setRegion(regions);
        countryService.save(country);
        regionService.save(region);
        return "countryRegions";
    }
}
