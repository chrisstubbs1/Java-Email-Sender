package com.example.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class EmailConfig {

    private JavaMailSender sender;
    private Logger logger = LoggerFactory.getLogger("logger");

    @Autowired
    public EmailConfig(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendEmail() throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        //this is where you will put the recipients email address
        helper.setTo("example@email.com");
        //this is where you put the message body
        helper.setText("Test from springboot");
        helper.setSubject("Hello");

        sender.send(message);
        logger.info("email sent");

    }
}
