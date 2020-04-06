package com.jeonghyeong.controller;

import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jeonghyeong.dto.Email;
import com.jeonghyeong.service.EmailService;

@RestController 
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	
	@RequestMapping("/email")
	public String emailSender(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("sender")String sender,
			@RequestParam("receiver")String receiver) throws UnsupportedEncodingException, MessagingException {
		Email email = new Email(title, content, sender, receiver);
		
		try {
			emailService.send(email);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		return "Sending Email is success, Please Check your Email.";
	}

}
