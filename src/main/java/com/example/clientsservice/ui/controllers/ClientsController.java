package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
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

import java.awt.*;
import java.util.List;

@Controller
public class ClientsController {
    @Qualifier(value = "clientServiceDb")
    @Autowired
    ClientService clientService;

    @GetMapping("clients")
    String load(Model model) {

        List<Client> list = clientService.findAll();
        model.addAttribute("clients", list);
        return "clients";
        //return "/mustache/clients";
    }

    @PostMapping("newClientForm")
    String newClientForm(@ModelAttribute Client client){

        clientService.save(client);
        return "redirect:/clients";
    }
    @PostMapping("clientUpdate")
    ModelAndView clientUpdate(@RequestParam("id")Integer id){
        return new ModelAndView("redirect:clientUpdate",
                new ModelMap("id",id));
    }

   /* @PostMapping("clientDelete")
     String clientDelete(@RequestParam("id")Integer id){
        return new P("redirect:clientUpdate",
                new ModelMap("id",id));
    }*/
}
