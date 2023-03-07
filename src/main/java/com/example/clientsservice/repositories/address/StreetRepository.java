package com.example.clientsservice.repositories.address;

import com.example.clientsservice.models.address.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street,Integer> {
}
