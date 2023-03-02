package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ClientsController {
    @Autowired
    ClientService clientService;

    @GetMapping("clients")
    String load(Model model) {

        List<Client> list = clientService.findAll();
        model.addAttribute("clients", list);
        return "clients";
    }
    /*//@PostMapping("newClientForm")
    String newClient(
            @RequestParam("surname") String surname,
            @RequestParam("name") String name,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("birthDate") String birtDate,
            @RequestParam("email") String email
    ){
        System.out.printf("%s %s %s %s %s ",surname,name,patronymic,birtDate,email);
        return "clients";
    }*/

    @PostMapping("newClientForm")
    String newClient(@ModelAttribute Client client){

        clientService.save(client);
        return "redirect:/clients";
    }
    @PostMapping("clientUpdateForm")
    ModelAndView clientUpdateForm(@RequestParam("id")Integer id){
        return new ModelAndView("redirect:clientUdate",
                new ModelMap("id",id));
    }
}
