package com.skillmanager.util;

import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUtil {

    private static final String EMAIL =
            "mohdgufran.bca29@gmail.com";

    private static final String APP_PASSWORD =
            "kqnwlrosopvxecji";

    public static void sendOtp(
            String toEmail,
            String otp) {

        try {

            Properties props =
                    new Properties();

            props.put(
                    "mail.smtp.host",
                    "smtp.gmail.com");

            props.put(
                    "mail.smtp.port",
                    "587");

            props.put(
                    "mail.smtp.auth",
                    "true");

            props.put(
                    "mail.smtp.starttls.enable",
                    "true");

            Session session =
                    Session.getInstance(
                            props,
                            new jakarta.mail.Authenticator() {

                @Override
                protected PasswordAuthentication
                        getPasswordAuthentication() {

                    return new PasswordAuthentication(
                            EMAIL,
                            APP_PASSWORD);
                }
            });

            Message message =
                    new MimeMessage(
                            session);

            message.setFrom(
                    new InternetAddress(
                            EMAIL));

            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(
                            toEmail));

            message.setSubject(
                    "Student_Skill_management_System Password Reset OTP");

            message.setText(
                    "Your OTP is: "
                    + otp
                    + "\n\nValid for 5 minutes.");

            Transport.send(
                    message);

            System.out.println(
                    "OTP Email Sent Successfully");

        } catch(Exception e) {

            e.printStackTrace();
        }
    }
}