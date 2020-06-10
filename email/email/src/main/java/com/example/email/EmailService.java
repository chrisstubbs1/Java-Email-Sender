package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements CommandLineRunner {

    private EmailConfig emailConfig;

    @Autowired
    public EmailService(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        emailConfig.sendEmail();
    }
}
