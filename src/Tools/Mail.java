/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.util.Properties;
import java.util.UUID;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Michail Sitmalidis
 */
public class Mail {

    final String username = "boxm1313@gmail.com";
    final String password = "athina2004";

    public boolean confirmationMailSent(String email, String url_token) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("boxm1313@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );

            message.setSubject("Registration Confirmation");
            message.setText("Dear Customer,"
                    + "\n\n Click the link to confirm your registration:" + url_token);

            Transport.send(message);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
