package com.email.service;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public boolean sendemail(String subject, String message, String to)
	{
		boolean f=false;
		
		String from="rakshubaby6789@gmail.com";
		//rakshubaby6789@gmail.com
		// coding part
		//variables for gmail

				String host="smtp.gmail.com";
				
				
				//get the system properties 
				Properties properties = System.getProperties();
				System.out.println("PROPERTIES "+properties);
				
				//setting important information to properties object
				
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", "465");
				properties.put("mail.smtp.ssl.enable", "true");
				properties.put("mail.smtp.auth", "true");
				
				
				
				
				//step 1: to get the session object 
				Session session=Session.getInstance(properties, new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication("rakshubaby6789@gmail.com","gculedlcwslmpavi");
					//password:rakshubaby gculedlcwslmpavi

					}
					
				});
				
				//step :2 compose the message[text, multimedia]
				
				MimeMessage m=new MimeMessage(session);
				
				try{
					//from email
					m.setFrom(from);
					
					//add recipient to message
					
					m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					
					
					//adding subject to message
					m.setSubject(subject);
					
					//adding text to message
					m.setText(message);
					
					
					//send
					
					
					//step:3 send the message using transport class
					
					Transport.send(m);
					
					System.out.println("sent success....................");
					f=true;
					
				} 
				catch (MessagingException e) {
					
					e.printStackTrace();
				}
				return f;
				
				
				
				
				
			}

		
		
	}