package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.address.Country;
import com.example.clientsservice.services.data.address.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CountryController {
    @Autowired
    @Qualifier("countryServiceDb")
    CountryService countryService;

    @GetMapping("country")
    String load(Model model){

        List<Country> countries = countryService.findAll();
        model.addAttribute("countries",countries);
        return "countries";
    }

    @PostMapping("countryRegions")
    ModelAndView regionUpdate(@RequestParam("id")Integer id){
        return new ModelAndView("redirect:countryRegions",
                new ModelMap("id",id));
    }
}
