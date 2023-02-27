package com.example.clientsservice.repositories;

import com.example.clientsservice.models.adress.CityType;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface CityTypeRepository extends JpaRepository<CityType, Integer> {
}
