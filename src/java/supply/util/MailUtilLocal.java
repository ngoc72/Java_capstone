/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supply.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


/**
 *
 * @author Ngoc
 */
public class MailUtilLocal {
    public static void sendImail(String to, String from, String subject, String body, boolean bodyIsHTML)
            throws MessagingException{
        Properties pros = new Properties();
        pros.put("mail.transport.protocl","smtp");
        pros.put("mail.smtp.host", "localhost");
        pros.put("mail.smtp.port", 25);
        Session session = Session.getDefaultInstance(pros);
        session.setDebug(true);
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if(bodyIsHTML){
            message.setContent(body, "text/html");
        }else{
            message.setText(body);
        }
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        
        message.setRecipient(Message.RecipientType.TO, toAddress);
        Transport.send(message);        
        
    }
}
