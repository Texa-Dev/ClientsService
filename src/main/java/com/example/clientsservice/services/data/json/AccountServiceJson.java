package com.example.clientsservice.services.data.json;
import com.example.clientsservice.models.Account;
import com.example.clientsservice.services.data.AccountService;
import com.example.clientsservice.services.data.qualifiers.QualifierAccountServiceJson;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

@Service
@QualifierAccountServiceJson
public class AccountServiceJson implements AccountService {
    @Autowired
    private Gson gson;
    private String fileName = "accounts.json";
    private String json;

    @Override
    public Account save(Account account) {
        json = gson.toJson(account);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Account> saveAll(List<Account> savingList) {
        json = gson.toJson(savingList);
        try {
            Files.write(Path.of(fileName), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account findById(Long id) {
        List<Account> all = findAll();
        return all.stream().filter(account -> Objects.equals(account.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public List<Account> findAll() {
        try {
            byte[] bytes = Files.readAllBytes(Path.of(fileName));
            String json = new String(bytes);
            return gson.fromJson(json, new TypeToken<List<Account>>() {
            }.getType());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        List<Account> all = findAll();
        all.removeIf(account -> Objects.equals(account.getId(), id));
        saveAll(all);
    }

    @Override
    public void deleteAll() {
        List<Account> all = findAll();
        all.clear();
        saveAll(all);
    }
}
