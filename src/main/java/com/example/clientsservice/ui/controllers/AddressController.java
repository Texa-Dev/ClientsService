package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.Address;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
public class AddressController {
    @Autowired
    @Qualifier("addressServiceDb")
    AddressService addressService;

    @GetMapping("addresses")
    String load(Model model,  @RequestParam("id") Integer id) {

        List<Address> addresses = addressService.findAll().stream().filter(address ->
                Objects.equals(address.getCity().getId(), id)).toList();
        model.addAttribute("addresses", addresses);
        return "addresses";
    }
    // Test
   /* @PostMapping("addressUpdate")
    String addressUpdate(@RequestParam("id") List<Client> clients) {

        for (Client client : clients) {
            System.out.println(client);
        }

        return "addresses";
    }*/
}
