package co.edu.uco.publiuco.infraestructure.adapter.email;

import co.edu.uco.publiuco.crosscutting.exception.ServicePubliUcoCustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import co.edu.uco.publiuco.crosscutting.exception.PubliUcoCustomException;
import co.edu.uco.publiuco.service.port.MailPort;

@Component
public class MailSenGridAdapter implements MailPort {

    @Value("${spring.sendgrid.api-key}")
    private String key;
    @Value("${email}")
    private String senderMail;

    @Override
    public void sendMail(String message, String user, String title) {
        Email sender = new Email(senderMail);
        Email receiver = new Email(user);
        Content content = new Content("text/plain", message);
        Mail mail = new Mail(sender, title, receiver, content);
        SendGrid sendGrid = new SendGrid(key);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
        } catch (PubliUcoCustomException exception) {
            throw exception;
        } catch (Exception exception) {
            throw ServicePubliUcoCustomException.createTechnicalException("An unexpected error occurred while trying to send the email",exception);
        }
    }
}