package com.example.clientsservice.repositories;

import com.example.clientsservice.models.adress.StreetName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetNameRepository extends JpaRepository<StreetName,Integer> {
}
