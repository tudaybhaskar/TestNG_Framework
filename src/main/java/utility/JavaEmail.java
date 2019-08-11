package utility;

/*import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.internal.BaseClassFinder;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication; 
*/
import javax.mail.Session;
/*
import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*;*/
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
//import javax.mail.*;

public class JavaEmail{
	static Session mailSession; 
	
	
	public static void sendEmail() throws AddressException, MessagingException
    {
		Properties emailProperties = System.getProperties();
	    emailProperties.put("mail.smtp.port", "586");
	    emailProperties.put("mail.smtp.auth", "true");
	    emailProperties.put("mail.smtp.starttls.enable", "true");
	    mailSession = Session.getDefaultInstance(emailProperties, null);
	    //
        String[] toEmails = { "udaybhaskar110@gmail.com" };
        String emailSubject = "Test email subject";
        String emailBody = "This is an email sent by <b>//howtodoinjava.com</b>.";
        MimeMessage emailMessage = new MimeMessage(mailSession);
        /**
         * Set the mail recipients
         * */
        for (int i = 0; i < toEmails.length; i++)
        {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
        }
        emailMessage.setSubject(emailSubject);
        /**
         * If sending HTML mail
         * */
        emailMessage.setContent(emailBody, "text/html");
        /**
         * If sending only text mail
         * */
        //emailMessage.setText(emailBody);// for a text email

        /**
         * Sender's credentials
         * */
        String fromUser = "test11selenium@gmail.com";
        String fromUserEmailPassword = "test@selenium123";
 
        String emailHost = "smtp.gmail.com";
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserEmailPassword);
        //
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }
	
	 
	
	
	/*
	 * public static void sendEmail() throws EmailException { Email email = new
	 * SimpleEmail(); email.setHostName("smtp.googlemail.com");
	 * email.setSmtpPort(465); email.setAuthenticator(new
	 * DefaultAuthenticator("test11selenium@gmail.com", "test@selenium123"));
	 * email.setSSLOnConnect(true); email.setFrom("test11selenium@gmail.com");
	 * email.setSubject("TestMail"); email.setMsg("This is a test mail ... :-)");
	 * email.addTo("udayabhaskar110@gmail.com"); email.send(); } public static void
	 * main(String[] args) { try { sendEmail(); } catch (EmailException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 */
	 

}
