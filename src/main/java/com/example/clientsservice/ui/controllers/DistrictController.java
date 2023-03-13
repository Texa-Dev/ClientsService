package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.address.District;
import com.example.clientsservice.models.address.Region;
import com.example.clientsservice.services.data.address.DistrictService;
import com.example.clientsservice.services.data.address.RegionService;
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
public class DistrictController {

    @Autowired
    @Qualifier("districtServiceDb")
    DistrictService districtService;

    @Autowired
    @Qualifier("regionServiceDb")
    RegionService regionService;

    @GetMapping("regionDistricts")
    public String load(Model model, @RequestParam("id") Integer id) {
        List<District> districts = regionService.findById(id).getDistrict();
        /*@Transaction*/
       /*   List<Region> regions = regionService.findAll().stream().
               filter(region -> Objects.equals(region.getCountry().getId(), id)).toList();
        model.addAttribute("regions", regions).addAttribute("country_id", id);*/
        model.addAttribute("districts", districts).addAttribute("id", id);
        return "regionDistricts";
    }

    @PostMapping("addNewDistrict")
    ModelAndView addNewDistrict(@RequestParam("district") String districtName, @RequestParam("id") Integer id) {
        Region region = regionService.findById(id);
        //Проверяем есть ли такой регион
        District district = region.getDistrict().stream().filter(dist ->
        dist.getDistrict().equals(districtName)).findFirst().orElse(null);
      //ДА, возвращаемся на страницу
        if (district != null) {
            return new ModelAndView("redirect:regionDistricts",
                    new ModelMap("id",id));
        }
        //НЕТ, создаем новый
        district = new District(0, districtName, null, null);
        district.setRegion(region);
        district= districtService.save(district);
        System.err.println(district);

        //Добавляем в список регионов страны
        List<District> districts = region.getDistrict();
        districts.add(district);
        region.setDistrict(districts);
        //сохраняем изменения в базу
        districtService.save(district);
        return new ModelAndView("redirect:regionDistricts",
                new ModelMap("id",id));
    }

    @PostMapping("districtCities")
    ModelAndView regionDistricts(@RequestParam("id") Integer id) {
        return new ModelAndView("redirect:districtCities",
                new ModelMap("id", id));
    }
}
