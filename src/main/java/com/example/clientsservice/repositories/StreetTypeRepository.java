package com.example.clientsservice.repositories;

import com.example.clientsservice.models.adress.StreetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetTypeRepository extends JpaRepository<StreetType,Integer> {
}
