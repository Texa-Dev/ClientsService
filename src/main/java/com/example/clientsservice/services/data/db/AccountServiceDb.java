package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.repositories.AccountRepository;
import com.example.clientsservice.services.data.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceDb implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> saveAll(List<Account> savingList) {
        List<Account> list = accountRepository.saveAll(savingList);
        return list.size()>0?list:null;
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public List<Account> findAll() {
        List<Account> list = accountRepository.findAll();
        return list.size()>0?list:null;
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        accountRepository.deleteAll();
    }
}
