package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientUpdateController {
    @Autowired
    @Qualifier(value = "clientServiceDb")
    ClientService clientService;

    @GetMapping("clientUpdate")
    public String load(Model model, @RequestParam("id") Integer id){
        Client client = clientService.findById(id);
        model.addAttribute("client",client);
        return "clientUpdate";
    }

    @PostMapping("clientUpdateForm")
    public String clientUpdateForm(@ModelAttribute Client client){
        clientService.save(client);
        return "redirect:clients";
    }
}

