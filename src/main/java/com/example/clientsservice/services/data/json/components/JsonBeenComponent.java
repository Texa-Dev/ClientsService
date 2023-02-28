package com.example.clientsservice.services.data.json.components;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;

public class JsonBeenComponent {
    @Bean
    public Gson gsonInstance(){
        return new Gson();
    }
}
