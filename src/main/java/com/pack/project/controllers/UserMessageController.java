package com.pack.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.project.Entity.UserMessage;
import com.pack.project.service.UserMessageService;

@RestController
@RequestMapping("/contact")
public class UserMessageController {
	@Autowired
	private UserMessageService userMessageService;
	
	@PostMapping("/usermsg")
	public ResponseEntity<String> save(@RequestBody UserMessage userMessage)
	{
		UserMessage um=userMessageService.save(userMessage);
		if(um.getMail().isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		else
			return ResponseEntity.ok("Message Sent Successfully!");
	}
	
	@GetMapping("/getmsgs")
	public List<UserMessage> getAll()
	{
		return userMessageService.findAll();
	}
	
	@GetMapping("/getById")
	public ResponseEntity<List<UserMessage>> getByUserID(@RequestParam("userid") String userid){
		List<UserMessage> li= userMessageService.getByUserId(userid);
		if(li.isEmpty())
		{
			return ResponseEntity.notFound().build();
		}
		else
			return ResponseEntity.ok(li);
	}
}
