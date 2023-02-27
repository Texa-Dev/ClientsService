package com.example.clientsservice.repositories.address;

import com.example.clientsservice.models.adress.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {
}
