package com.example.clientsservice.repositories;

import com.example.clientsservice.models.adress.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street,Integer> {
}
