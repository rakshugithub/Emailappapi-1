package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.service.EmailService;

@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired
	private EmailService emailService ;
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "Hello this is my email api";
	}
	//api to send email
	
	@RequestMapping(value="/sendemail",method=RequestMethod.POST)
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request)
	{
		
	    boolean result=this.emailService.sendemail(request.getSubject(), request.getMessage(), request.getto());
		System.out.println(request);
		if(result)
		{
		return ResponseEntity.ok("Email is send successfully");
		}
		else
		{
			return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
//		System.out.println(request);
//		return ResponseEntity.ok("Email is send successfully");


	}

}
