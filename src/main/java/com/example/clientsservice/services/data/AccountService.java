package com.example.clientsservice.services.data;

import com.example.clientsservice.models.Account;

import java.util.List;

public interface AccountService {
    Account save(Account account);

    List<Account> saveAll(List<Account> savingList);

    Account findById(Long id);

    List<Account> findAll();

    void deleteById(Long id);

    void deleteAll();
}
