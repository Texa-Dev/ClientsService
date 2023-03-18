package com.example.clientsservice.services.timing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailingService {
    static final String subject="Account expired out";

  //  @Bean
    public JavaMailSender getMailSender(){
        return new JavaMailSenderImpl();
    }
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText("body");

        mailSender.send(mailMessage);
    }
}
