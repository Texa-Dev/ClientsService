package com.example.clientsservice.repositories;

import com.example.clientsservice.models.adress.CityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityNameRepository extends JpaRepository<CityName, Integer> {
}
