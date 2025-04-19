package com.pack.project.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "usermessage")
public class UserMessage {
	
	private String userid;
	private String name;
	private String mail;
	private long number;
	private String message;

}
