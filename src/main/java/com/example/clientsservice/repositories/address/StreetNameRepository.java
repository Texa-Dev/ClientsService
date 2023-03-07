package com.example.clientsservice.repositories.address;

import com.example.clientsservice.models.address.StreetName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetNameRepository extends JpaRepository<StreetName,Integer> {
}
