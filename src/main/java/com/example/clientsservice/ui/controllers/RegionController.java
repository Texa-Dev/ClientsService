package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.address.Country;
import com.example.clientsservice.models.address.Region;
import com.example.clientsservice.services.data.address.CountryService;
import com.example.clientsservice.services.data.address.RegionService;
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
        /*@Transaction
          List<Region> regions = regionService.findAll().stream().
               filter(region -> Objects.equals(region.getCountry().getId(), id)).toList();*/
        model.addAttribute("regions", regions).addAttribute("country_id", id);
        return "countryRegions";
    }

    @PostMapping("addNewRegion")
    ModelAndView addNewRegion(@RequestParam("region") String regionName, @RequestParam("id") Integer id) {
//находим Страну
        Country country = countryService.findById(id);
        //Проверяем есть ли такой регион
        Region region = country.getRegion().stream().filter(reg -> reg.getRegion().equals(regionName)).findFirst().orElse(null);
        //ДА, возвращаеимся на страницу
        if (region != null) {
            return new ModelAndView("redirect:countryRegions");
        }
        //НЕТ, создаем новый
        region = new Region(0, regionName, null, null);
        region.setCountry(country);
        region = regionService.save(region);
        //Добавляем в список регионов страны
        List<Region> regions = country.getRegion();
        regions.add(region);
        country.setRegion(regions);
        //сохраняем изменения в базу
        countryService.save(country);
        return new ModelAndView("redirect:countryRegions",
                new ModelMap("id", id));
    }

    @PostMapping("regionDistricts")
    ModelAndView regionDistricts(@RequestParam("id") Integer id) {
        return new ModelAndView("redirect:regionDistricts",
                new ModelMap("id", id));
    }
}
