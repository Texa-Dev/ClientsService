package com.example.clientsservice.ui.controllers;

import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.User;
import com.example.clientsservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @PostMapping("registerUser")
    String registration(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/";
    }
}
