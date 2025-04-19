package com.pack.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.project.Entity.Workers;
import com.pack.project.service.WorkerServices;


@RestController
@RequestMapping("/workers")
public class WorkersController {
	
	@Autowired
	private WorkerServices workerservices;
	
	@PostMapping("/add")
	Workers insert(@RequestBody Workers worker)
	{
		return workerservices.save(worker);
	}
	
	
	@PostMapping("/filter")
	ResponseEntity<List<Workers>> getWorkers(@RequestBody Workers workers)
	{
		List<Workers> li= workerservices.getWorkers(workers);
		
		if(li.isEmpty()){
			return ResponseEntity.notFound().build();
		}
		else
			return ResponseEntity.ok(li);
		
	}
	
	@GetMapping("/getall")
	List<Workers> getMethodName() {
		return workerservices.getAllWorkers();
	}
	
	@PostMapping("/validate")
	ResponseEntity<?> validate(@RequestBody Workers worker)
	{
		Workers found=workerservices.validateWorker(worker);
		if (found != null) {
	        return ResponseEntity.ok(found);
	    } else {
	        return ResponseEntity
	                .notFound().build();
	    }				
	}
	
	@PostMapping("/profileupdate")
	String profileUpdate(@RequestBody Workers worker) {
		int result=workerservices.profileUpdating(worker);
		if(result>0)
			return worker.getFirstname()+ " Profile Added Succefully.";
		else
			return "Profile Not Updated";
	}
	
	

}
