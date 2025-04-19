package com.pack.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.project.Entity.Feedbacks;
import com.pack.project.repository.FeedbackRepository;

@Service
public class FeedbackService{
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	

	public List<Feedbacks> getAll()
	{
		return feedbackRepository.findAll();
	}
	
	public List<Feedbacks> getByUserId(String userid)
	{
		return feedbackRepository.findByUserid(userid);
	}
}
