package services;

import models.Kata;
import org.junit.*;

import static org.mockito.Mockito.*;

import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;
import views.html.emailbody;

public class MailerServiceTest {

    public MailerService mailer;
    public Email mockedEmail;
    public Kata kata;
    private MailerClient mockedClient;

    @Before
    public void setup(){
        // Create and train mock
        mockedEmail = mock(Email.class);
        mockedClient = mock(MailerClient.class); 
        mailer = new MailerService(mockedEmail, mockedClient);
        kata = new Kata();
    }

    @Test
    public void itShouldSetTheEmailSubject() {
        kata.candidateName = "Jane Doe";
        mailer.send(kata);
        verify(mockedEmail).setSubject("Generated Kata Results: Jane Doe");

        kata.candidateName = "John Doe";
        mailer.send(kata);
        verify(mockedEmail).setSubject("Generated Kata Results: John Doe");
    }

    @Test
    public void itShouldSetTheRecipient() {
        kata.recruiterEmail = "jdoe@pillartechnology.com";
        mailer.send(kata);
        verify(mockedEmail).addTo("jdoe@pillartechnology.com");
    }

    @Test
    public void itShouldSetTheSender() {
        mailer.send(kata);
        verify(mockedEmail).setFrom("no-reply@pillartechnology.com");
    }

    @Test
    public void itShouldSetTheEmailBody(){
        mailer.send(kata);
        verify(mockedEmail).setBodyHtml(emailbody.render(kata).toString());
    }

    @Test
    public void itShouldSendTheEmail(){
        mailer.send(kata);
        verify(mockedClient).send(mockedEmail);
    }
}
