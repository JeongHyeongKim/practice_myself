package com.jeonghyeong.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Email {
	
	private String title;
	private String content;
	private String sender;
	private String receiver;
	private String attachmentURL;
	
	
	public Email(String emailTitle, String emailContent, String sender, String receiver) {
		this.title=emailTitle;
		this.content = emailContent;
		this.sender = sender;
		this.receiver = receiver;
		
	}
	
	

}
