package com.apostle.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{
    @Autowired
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;



    @Override
    public void sendPasswordResetEmail(String toEmail, String token) throws MessagingException {
        String subject = "Your Password Reset Code";
        String body = "Use the following reset code: " + token + "\nThis code will expire in 10 minutes.";

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

        helper.setFrom(from);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body, false);

        javaMailSender.send(message);
    }
}
