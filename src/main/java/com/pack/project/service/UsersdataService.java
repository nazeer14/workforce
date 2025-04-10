package com.pack.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.project.Entity.Users;
import com.pack.project.repository.UsersdataRepository;

@Service
public class UsersdataService {

	@Autowired
	private UsersdataRepository usersdataRepository;
	
	public Users addUser(Users user)
	{
		return usersdataRepository.save(user);
	}
	
	public Users getUserById(long id)
	{
		return usersdataRepository.getByUserId(id);
	}
	
	public Users validate(Users user)
	{
		return usersdataRepository.validate(user.getMobileno(),user.getPassword());
	}
	
	public int resetPassword(Users user)
	{
		return usersdataRepository.updatePassword(user.getMobileno(),user.getPassword());
	}
}
