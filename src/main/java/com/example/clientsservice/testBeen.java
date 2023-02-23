package com.example.clientsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

//@Service
public class testBeen {
    private final SomeBeen someBeen;

    public testBeen(SomeBeen someBeen) {
        this.someBeen = someBeen;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onLoad(){
        System.out.println(someBeen);
    }
}
