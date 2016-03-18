package services;

import models.Kata;
import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;
import views.html.emailbody;

public class MailerService {

    private Email email;
    private MailerClient client;

    public MailerService(Email email, MailerClient client) {
        this.email = email;
        this.client = client;
    }

    public void send(Kata kata){
        this.email.setSubject("Generated Kata Results: " + kata.candidateName);
        this.email.addTo(kata.recruiterEmail);
        this.email.setFrom("no-reply@pillartechnology.com");
        this.email.setBodyHtml(emailbody.render(kata).toString());
        this.client.send(email);
    }
}
