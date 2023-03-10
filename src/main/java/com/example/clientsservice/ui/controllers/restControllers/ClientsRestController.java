package com.example.clientsservice.ui.controllers.restControllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientsRestController {
    @Autowired
    @Qualifier("clientServiceDb")
    ClientService clientService;


    @PostMapping("/rest/addNewClient")
    public ResponseEntity<?> addNewClient(@RequestBody Client client){
       clientService.save(client);
        List<Client> all = clientService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}
