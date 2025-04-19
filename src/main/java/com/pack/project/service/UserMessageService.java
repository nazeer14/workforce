package com.pack.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.project.Entity.UserMessage;
import com.pack.project.repository.UserMessageRepository;

@Service
public class UserMessageService {
	@Autowired
	private UserMessageRepository userMessageRepository;
	
	public UserMessage save(UserMessage usermessage)
	{
		return userMessageRepository.save(usermessage);
	}
	
	public List<UserMessage> findAll()
	{
		return userMessageRepository.findAll();
	}
	
	public List<UserMessage> getByUserId(String userid){
		return userMessageRepository.findByuserid(userid);
	}

}
