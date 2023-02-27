package com.example.clientsservice.repositories.address;

import com.example.clientsservice.models.adress.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District,Integer> {
}
