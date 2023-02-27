package com.example.clientsservice.repositories.address;

import com.example.clientsservice.models.adress.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
}
