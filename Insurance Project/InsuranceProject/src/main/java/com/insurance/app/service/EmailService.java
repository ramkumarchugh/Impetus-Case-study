package com.insurance.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Provide Email Services.
 */
@Service
public class EmailService{
    
    @Autowired
    private JavaMailSender sender;
    
    public JavaMailSender getSender() {
        return sender;
    }


    public void setSender(JavaMailSender sender) {
        this.sender = sender;
    }
    
    

    @Async
    public void sendSimpleMessage(String to, String subject, String text) throws MailException{
        
        SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom("insurance.root12@gmail.com");
            mail.setTo(to);
            mail.setText(text);
            mail.setSubject(subject);
            sender.send(mail);
    }

}

