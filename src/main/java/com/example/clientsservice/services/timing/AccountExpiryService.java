package com.example.clientsservice.services.timing;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.services.data.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountExpiryService {
    @Autowired
    @Qualifier("accountServiceDb")
    AccountService accountService;

    @Bean("getExecutor")
    public TaskExecutor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(100);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }

    @Async("getExecutor")
    public void expired() {
       // List<Account>
        accountService.findAllByExpiredDateIsLessThan(LocalDate.now());
    }
}
