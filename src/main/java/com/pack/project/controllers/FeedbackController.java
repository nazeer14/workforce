package com.pack.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.project.Entity.Feedbacks;
import com.pack.project.service.FeedbackService;

@RestController
@RequestMapping("/fb")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping("/feedback")
	public List<Feedbacks> getFeedbackByUserId(@RequestParam("userid") String userId) {
		System.out.println(userId);
	    List<Feedbacks> li=feedbackService.getByUserId(userId);
	    return li;
	}
	
	@GetMapping("/getall")
	public List<Feedbacks> getAll()
	{
		return feedbackService.getAll();
	}
	
}
