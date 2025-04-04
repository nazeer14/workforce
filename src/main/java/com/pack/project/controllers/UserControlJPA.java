package com.pack.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.project.Entity.User;
import com.pack.project.service.UserServiceJPA;

@RestController
@RequestMapping("/jpa")
public class UserControlJPA {

	@Autowired
	private UserServiceJPA userService;
	
	@GetMapping("/get")
	public List<User> getAll()
	{
		return userService.getAll();
	}
	
	@PostMapping("/add")
	public User save(@RequestBody User user)
	{
		return userService.save(user);
	}
	
	 @PostMapping("/validate")
	 public User getbyusername(@RequestBody User user)
	 {
		 return userService.validate(user.getUsername(),user.getPassword());
	 }
	 
	 @PostMapping("/forgot")
	 public String forgot(@RequestBody User user)
	 {
		 User un=userService.forgot(user);
		 if(un==null)
		 {
			 return "fail";
		 }
		 else 
			 return un.getUsername();
	 }
}
