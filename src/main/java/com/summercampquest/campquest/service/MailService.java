package com.summercampquest.campquest.service;

import com.sendgrid.Method;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.Request;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MailService {
    @Autowired
    SendGrid sendGrid;
    public String sendEmail(String email, String token)  {

        try {
            Mail mail = prepareMail(email, token);

            Request request = new Request();

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sendGrid.api(request);

            if(response!=null) {


                System.out.println("response code from sendgrid"+response.getStatusCode() + "," + response.getBody());

            }

        } catch (IOException e) {


            e.printStackTrace();
            return "error in sent mail!";
        }

        return "mail has been sent check your inbox!";

    }

    public Mail prepareMail(String email, String token) {

        Mail mail = new Mail();

        Content content = new Content();
        content.setType("text/html");
//        content.setType("Plz click the link in 15 minutes");
        content.setValue("http://localhost:4200/reset-password?token="+token);

        mail.addContent(content);

        Email fromEmail = new Email();
        fromEmail.setEmail("saran.launchcode@gmail.com");
        mail.setFrom(fromEmail);

        Email to = new Email();
        to.setEmail(email);


        Personalization personalization = new Personalization();
        personalization.addTo(to);
        personalization.setSubject("Password reset Request");
        mail.addPersonalization(personalization);

        return mail;
    }

}
