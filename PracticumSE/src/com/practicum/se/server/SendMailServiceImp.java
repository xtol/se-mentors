package com.practicum.se.server;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.practicum.se.client.SendMailService;

public class SendMailServiceImp extends RemoteServiceServlet implements
		SendMailService {

	private static final long serialVersionUID = 3880131608918763905L;

	public String sendMail(String sendto, String message_mi) {
		// TODO Auto-generated method stub
		// Recipient's email ID needs to be mentioned.
		String sender_email = "twinkletalways@gmail.com", sender_host = "smtp.gmail.com", sender_port = "465", reciever_id = sendto, subject_to_be_given = "Authentication Email verification";
		String st = "true";
		Properties props = new Properties();
		props.put("mail.smtp.user", sender_email);
		props.put("mail.smtp.host", sender_host);
		props.put("mail.smtp.port", sender_port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", sender_port);
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallb", "false");
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(session);

			String message = "<div style=\"color:red;\"><table><tr><td>Welcome to Authentication</td></tr><tr><td> Your code: </td></tr></table>"
					+ message_mi + "</div>";
			msg.setContent(message, "text/html; charset=utf-8");

			msg.setSubject(subject_to_be_given);
			msg.setFrom(new InternetAddress(sender_email));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					reciever_id));
			Transport.send(msg);
		} catch (Exception mex) {
			mex.printStackTrace();
			st = "false";
			System.out.println("inside javamail exception");
			System.out.println("error------>" + mex);

		}
		return st;

	}

}

class SMTPAuthenticator extends javax.mail.Authenticator {
	String sender_email = "twinkletalways@gmail.com",
			sender_password = "Twinkleall", sender_host = "smtp.gmail.com",
			sender_port = "465",
			subject_to_be_given = "TF4U", message_mi = "Welcome to TF4U.";

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(sender_email, sender_password);
	}
}