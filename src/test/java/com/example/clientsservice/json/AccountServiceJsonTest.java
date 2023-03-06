package com.example.clientsservice.json;
import com.example.clientsservice.models.Account;
import com.example.clientsservice.services.data.AccountService;
import com.example.clientsservice.services.data.qualifiers.QualifierAccountServiceJson;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountServiceJsonTest {
    @QualifierAccountServiceJson
    @Autowired
    private AccountService accountService;

    static Account account = new Account(1L, 10000.0, null);
    static Account account1 = new Account(2L, 500000.0, null);
    static Account account2 = new Account(3L, 10.0, null);

    static Account testOne;
    static List<Account> testList;
    @Test
    @Order(1)
    void save(){
        testOne = accountService.save(account);
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, account);
    }
    @Test
    @Order(2)
    void saveAll(){
        List<Account> saving = List.of(account1,account2);
        testList = accountService.saveAll(saving);
        assertNotNull(testList);
        assertEquals(testList, saving);
    }
    @Test
    @Order(3)
    void findById(){
        testOne= accountService.findById(account1.getId());
        System.out.println(testOne);
        assertNotNull(testOne);
        assertEquals(testOne, account1);
    }
    @Test
    @Order(4)
    void findAll(){
        testList = accountService.findAll();
        testList.forEach(System.out::println);
        assertNotNull(testList);
        assertEquals(testList, accountService.findAll());
    }
    @Test
    @Order(5)
    void deleteById(){
        accountService.deleteById(account2.getId());
        assertNull(accountService.findById(account2.getId()));
        accountService.findAll().forEach(System.out::println);
    }
    @Test
    @Order(6)
    void deleteAll(){
        accountService.deleteAll();
        assertNull(accountService.findAll());
    }

}
