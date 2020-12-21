package com.codehub.projectfuture.team3.PropertyRepairWebApp.email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {
    private static String USER_NAME = "repairapp.pf";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "Repair1234"; // GMail password
    private static String subject = "Welcome to repair app!";


    public static void sendFromGMail(String recipient, String password) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(USER_NAME));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            String body = "<h1>Welcome to MyRepair !</h1>\n" +
                    "<h4>Your password is "+ password + "</h4>\n" +
                    "<p>We recommend to change your password after your first login.</p>";

            message.setSubject(subject);
            message.setContent(body, "text/html; charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
