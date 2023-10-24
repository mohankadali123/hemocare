package com.programerthings.firstpro.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;
import org.springframework.core.io.ClassPathResource;

import jakarta.mail.internet.MimeMessage;

import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    
    @Async
    public void sendSimpleEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }
    
    
    //newthings starts from here
    @Autowired
    private TemplateEngine templateEngine;
    
    @Async
    public void sendHtmlEmail(String to, String subject, String name,String name2,String mail,String postalCode,String phoneNumber,String bloodGroup) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // Set recipient, subject, and other properties
            helper.setTo(to);
            helper.setSubject(subject);

            // Create a context for Thymeleaf template
            Context context = new Context();
            context.setVariable("name", name);
            context.setVariable("bloodGroup",bloodGroup);
            context.setVariable("name2", name2);
            context.setVariable("mail", mail);
            context.setVariable("postalCode", postalCode);
            context.setVariable("phoneNumber", phoneNumber);
            

            // Process the template with Thymeleaf
            String htmlContent = templateEngine.process("mail.html", context);
            helper.setText(htmlContent, true);

            // You can also add attachments if needed
            // helper.addAttachment("attachment.pdf", new ClassPathResource("attachment.pdf"));

            javaMailSender.send(message);
        } catch (Exception e) {
            // Handle exceptions
        }
}
}
