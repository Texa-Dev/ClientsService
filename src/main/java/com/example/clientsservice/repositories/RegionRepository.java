package com.example.clientsservice.repositories;

import com.example.clientsservice.models.adress.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Integer> {
}
