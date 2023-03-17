package com.example.clientsservice.services.data.db;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.AccountService;
import com.example.clientsservice.services.data.ClientService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountServiceDbTest {
    @Autowired
    @Qualifier("accountServiceDb")
    AccountService accountService;

    @Autowired
    @Qualifier("clientServiceDb")
    ClientService clientService;
    static Account account = new Account(1L,10000, LocalDate.of(2023,3,20), null);
    static Account account1 = new Account(2L, 500000.0,LocalDate.of(2023,3,15), null);
    static Account account2 = new Account(3L, 10.0, LocalDate.of(2023,3,10),null);

    static Account testOne;
    static List<Account> testList;

    @Test
    @Order(1)
    void save() {
        testOne = accountService.save(account);
        assertNotNull(testOne);
        assertEquals(testOne, account);
        System.out.println(testOne);
    }

    @Test
    @Order(2)
    void saveAll() {
        List<Account> savingList = List.of(account1, account2);
        testList = accountService.saveAll(savingList);
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(savingList, testList);
    }

    @Test
    @Order(3)
    void findById() {
        testOne = accountService.findById(account1.getId());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, account1);

    }

    @Test
    @Order(3)
    void findAll() {
        testList = accountService.findAll();
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(testList, accountService.findAll());

    }

    @Test
    @Order(4)
    void deleteById() {
        accountService.deleteById(account1.getId());
        assertNull(accountService.findById(account1.getId()));
        accountService.findAll().forEach(System.out::println);
    }

    @Test
    @Order(5)
    void deleteAll() {
        // accountService.findAll().forEach(System.out::println);
        accountService.deleteAll();
        assertNull(accountService.findAll());
    }
}
