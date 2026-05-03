package com.studentform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String toEmail, String name) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Email Verification");
        message.setText(
                "Hello " + name + ",\n\n" +
                "Thank you for registering.\n\n" +
                "Regards,\nStudent Form Team"
        );
        message.setFrom("drsoitani10@gmail.com");

        try {
            mailSender.send(message);
            System.out.println("✅ Email sent successfully");

        } catch (Exception e) {
            System.out.println("❌ First attempt failed, retrying...");

            try {
                Thread.sleep(2000); // wait 2 sec
                mailSender.send(message);
                System.out.println("✅ Email sent on retry");

            } catch (Exception ex) {
                System.out.println("❌ Email failed completely");
                ex.printStackTrace();
            }
        }
    }
}
