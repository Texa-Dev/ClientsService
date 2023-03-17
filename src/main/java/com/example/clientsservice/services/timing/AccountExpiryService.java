package com.example.clientsservice.services.timing;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.services.data.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service
public class AccountExpiryService {
    @Autowired
    @Qualifier("accountServiceDb")
    AccountService accountService;
@Autowired
MailingService mailingService;

    @Bean("getExecutor")
    public TaskExecutor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(100);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }

    @Async//("getExecutor")
    public Future<List<Entry<String,Long>>> expired() throws InterruptedException {
       // List<Account>
        List<Account> accounts = accountService.findAllByExpiredDateIsLessThan(LocalDate.now());
        List<Entry<String, Long>> list = new ArrayList<>();
        for (Account account : accounts) {
            for (Client client : account.getClients()) {
               list.add(new AbstractMap.SimpleEntry<>(client.getEmail(),account.getId()));
            }
        }
     //   TimeUnit.SECONDS.sleep(5);
        return new AsyncResult<>(list);
    }
    @Async
    @Scheduled(cron = "*/10 * * * * *")
    public void start(){
        try{
            Future<List<Entry<String, Long>>> future = expired();
            while (!future.isDone()){
                TimeUnit.MILLISECONDS.sleep(10);
            }

            List<Entry<String, Long>> entries = future.get();
            System.err.println(LocalDateTime.now());
            entries.forEach(System.out::println);

           /* entries.forEach(stringLongEntry -> mailingService.sendEmail(stringLongEntry.getKey(),
                    stringLongEntry.getValue().toString()));*/
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
