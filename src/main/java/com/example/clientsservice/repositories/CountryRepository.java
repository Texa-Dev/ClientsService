package com.example.clientsservice.repositories;

import com.example.clientsservice.models.adress.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {
}
