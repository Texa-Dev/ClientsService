package com.example.clientsservice.repositories.address;

import com.example.clientsservice.models.address.CityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityNameRepository extends JpaRepository<CityName, Integer> {
}
