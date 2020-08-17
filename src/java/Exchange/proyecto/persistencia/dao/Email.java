/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exchange.proyecto.persistencia.dao;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Sena
 */
public class Email {

    @SuppressWarnings("empty-statement")
    public boolean enviarCorreo(String para, String mensaje, String asunto) {
        boolean enviado = false;
        try{
       String host = "smtp.gmail.com";
             String de = "exchangeintercambios@gmail.com";
            String clave = "Exchange2019";
            Properties prop = System.getProperties();
            
            prop.put("mail.smtp.host", host);
            prop.put("mail.smtp.user", de);
            prop.put("mail.smtp.clave", clave);
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");;
          /*  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.put("mail.smtp.socketFactory.port", "587");
            prop.put("mail.smtp.socketFactory.fallback", "false");*/
            
            Session sesion = Session.getDefaultInstance(prop, null);
            
            MimeMessage message = new MimeMessage(sesion);
          
            
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
            
            message.setSubject(asunto);
            message.setText(mensaje);
            
            Transport transport = sesion.getTransport("smtp");
            
            transport.connect(host,de, clave);
            
            transport.sendMessage(message, message.getAllRecipients());
            
            transport.close();
            enviado = true;
        } catch (MessagingException e) {
        }
      

        return enviado;
    }
    public void actualizardatos(String para, String mensaje, String asunto) {
        boolean enviado = false;
        try{
       String host = "smtp.gmail.com";
             String de = "exchangeintercambios@gmail.com";
            String clave = "Exchange2019";
            Properties prop = System.getProperties();
            
            prop.put("mail.smtp.host", host);
            prop.put("mail.smtp.user", de);
            prop.put("mail.smtp.clave", clave);
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");;
          /*  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.put("mail.smtp.socketFactory.port", "587");
            prop.put("mail.smtp.socketFactory.fallback", "false");*/
            
            Session sesion = Session.getDefaultInstance(prop, null);
            
            MimeMessage message = new MimeMessage(sesion);
          
            
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
            
            message.setSubject(asunto);
            message.setText(mensaje);
            
            Transport transport = sesion.getTransport("smtp");
            
            transport.connect(host,de, clave);
            
            transport.sendMessage(message, message.getAllRecipients());
            
            transport.close();
            
        } catch (MessagingException e) {
        }
      

        
    }
    public void recuperContraseña(String para, String mensaje, String asunto) {
        boolean enviado = false;
        try{
       String host = "smtp.gmail.com";
             String de = "exchangeintercambios@gmail.com";
            String clave = "Exchange2019";
            Properties prop = System.getProperties();
            
            prop.put("mail.smtp.host", host);
            prop.put("mail.smtp.user", de);
            prop.put("mail.smtp.clave", clave);
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");;
          /*  prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            prop.put("mail.smtp.socketFactory.port", "587");
            prop.put("mail.smtp.socketFactory.fallback", "false");*/
            
            Session sesion = Session.getDefaultInstance(prop, null);
            
            MimeMessage message = new MimeMessage(sesion);
          
            
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(para));
            
            message.setSubject(asunto);
            message.setText(mensaje);
            
            Transport transport = sesion.getTransport("smtp");
            
            transport.connect(host,de, clave);
            
            transport.sendMessage(message, message.getAllRecipients());
            
            transport.close();
            
        } catch (MessagingException e) {
        }
      

        
    }
}
