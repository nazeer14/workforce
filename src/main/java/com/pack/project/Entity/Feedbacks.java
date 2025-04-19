package com.pack.project.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document(collection = "feedback")
public class Feedbacks {
	
	 @Id
	private String id;
	private String userid;
	private String name;
	private long number;
	private String message;

}
