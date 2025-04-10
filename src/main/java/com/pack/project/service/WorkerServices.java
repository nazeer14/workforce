package com.pack.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.project.Entity.Workers;
import com.pack.project.repository.WorkersRepository;

@Service
public class WorkerServices {
	
	@Autowired
	private WorkersRepository workersRepository;
	
	public Workers save(Workers workers)
	{
		return workersRepository.save(workers);
	}
	public List<Workers> getWorkers(Workers worker)
	{
		System.out.println("Location: " + worker.getPreferedLocation());
		System.out.println("Category: " + worker.getWorkCategory());
		System.out.println("Gender: " + worker.getGender());

		return workersRepository.findWorkers(worker.getPreferedLocation(),worker.getWorkCategory(), worker.getGender());
	}
	
	public List<Workers> getAllWorkers()
	{
		return workersRepository.findAll();
	}
	
	
	/*public int updateById(Workers worker)
	{
		return workersRepository.update(worker.getId(),worker.getFirstname(),worker.getLastname());
	}*/

	
}
