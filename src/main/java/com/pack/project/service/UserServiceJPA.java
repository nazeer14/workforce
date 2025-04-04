package com.pack.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.project.Entity.User;
import com.pack.project.repository.UserRepositoryJPA;

@Service
public class UserServiceJPA {
	
	 @Autowired
	    private UserRepositoryJPA userRepository;

	 public List<User> getAll()
	 {
		 return userRepository.findAll();
	 }
	 
	 public User save(User user)
	 {
		 return userRepository.save(user);
	 }
	 
	 public User validate(String username,String password)
	 {
		 return userRepository.validate(username, password);
	 }
	 
	 public User forgot(User user)
	 {
		 return userRepository.forgot(user.getMail(),user.getPhoneno());
	 }
	 
	 

}
