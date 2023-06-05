package co.edu.uco.publiuco.service.port;

public interface MailPort {

    void sendMail(String message, String user, String title);
}
