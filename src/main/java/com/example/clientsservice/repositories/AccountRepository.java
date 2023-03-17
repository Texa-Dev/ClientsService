package com.example.clientsservice.repositories;

import com.example.clientsservice.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByExpiredDateIsLessThan(LocalDate currentDate);
}
