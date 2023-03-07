package com.example.clientsservice.repositories.address;

import com.example.clientsservice.models.address.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region,Integer> {
}
