package com.pack.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.project.Entity.Users;
import com.pack.project.service.UsersdataService;


@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersdataService usersdataService;
	
	@PostMapping("/adduser")
	Users adduser(@RequestBody Users user ) {
		return usersdataService.addUser(user);
	}
	
	@GetMapping("/get14")
	public ResponseEntity<Users> getUserById(@RequestParam("id") long id)
    {
	    Users user= usersdataService.getUserById(id);
	    
	    if(user==null)
	    {
	    	return ResponseEntity.notFound().build();
	    }
	    System.out.println(user.getMobileno());
	    return ResponseEntity.ok(user);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<Users> validateUser(@RequestBody Users user)
	{
		Users us=usersdataService.validate(user);
		if(us==null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(us);
	}
	
	@PostMapping("/reset")
	public ResponseEntity<String> resetPassword(@RequestBody Users user)
	{
		int res=usersdataService.resetPassword(user);
		if(res>0)
			return ResponseEntity.ok("Successfully updated password");
		else
			return ResponseEntity.notFound().build();
			
	}
}