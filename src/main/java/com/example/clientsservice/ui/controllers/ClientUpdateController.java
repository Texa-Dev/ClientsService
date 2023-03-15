package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.AddressService;
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

    @Autowired
    @Qualifier("addressServiceDb")
    AddressService addressService;
    @GetMapping("clientUpdate")
    public String load(Model model, @RequestParam("id") Integer id){
        Client client = clientService.findById(id);
        Address address = addressService.findById(client.getAddress().getId());
        if (address!=null) {
            model.addAttribute("client", client).addAttribute("address",address);
            return "clientUpdate";
        }
        model.addAttribute("client", client).addAttribute("address", new Address());
        return "clientUpdate";
    }

    @PostMapping("clientUpdateForm")
    public String clientUpdateForm(@ModelAttribute Client client){
        clientService.save(client);
        return "redirect:clients";
    }
}

