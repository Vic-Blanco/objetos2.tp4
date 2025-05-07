package ejercicio2.database;

import ejercicio2.model.EnviarSaludo;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;


public class PorMailEnviarSaludo implements EnviarSaludo {

    @Override
    public void enviar(String mailTo,String subject, String content) {

       // String to = "your.recipient@email.com";
        String to = mailTo;
        // provide sender's email ID
        String from = "john.doe@your.domain";

        // provide Mailtrap's username
        final String username = "108573efd6dec6";
        final String password = "fc68cd754411a6";


        // provide Mailtrap's host address
        String host = "sandbox.smtp.mailtrap.io";

        // configure Mailtrap's SMTP details
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "2525");
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // create a MimeMessage object

            Message message = new MimeMessage(session);
            // set From email field
            message.setFrom(new InternetAddress(from));
            // set To email field
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // set email subject field
            message.setSubject(subject);
            // set the content of the email message
            message.setText(content);

            // send the email message
            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
