package com.pack.project.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.project.Entity.User;
import com.pack.project.repository.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserRepo userRepo;

	public UserController(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	@PostMapping("/add")
	public int addUser(@RequestBody User user)
	{
		return userRepo.addUser(user);
	}
	
	@GetMapping("/login")
	public String validateUser(@RequestBody User user)
	{
		
		List<User> list=userRepo.getUser(user);
		return list.isEmpty()?"fail":"success";
	}
	
	@PostMapping("/insert")
	public String insertUser(@RequestBody User user) throws SQLException
	{
		//return userRepo.insert(user)>0?"success":"fail";

		try
		{
			return userRepo.insert(user)>0?"success":"fail";
			
		}catch(SQLException e)
		{
			System.out.println(e.getLocalizedMessage());
			return "fail";
		}
	}
	

}
