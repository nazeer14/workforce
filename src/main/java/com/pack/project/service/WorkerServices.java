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

		return workersRepository.findWorkers(worker.getPreferedLocation(),worker.getWorkCategory(), worker.getGender());
	}
	
	public List<Workers> getAllWorkers()
	{
		return workersRepository.findAll();
	}
	
	public Workers validateWorker(Workers worker)
	{
		return workersRepository.login(worker.getNumber(),worker.getPassword());
	}
	
	public int profileUpdating(Workers worker)
	{
		return workersRepository.profileUpdate(worker.getFirstname(),worker.getLastname(),worker.getAddress(),worker.getGender(),worker.getWorkCategory(),worker.getPreferedLocation(),worker.getEmail(),worker.getProfileImage(),worker.getStatus(),worker.getId());
	}
	
	/*public int updateById(Workers worker)
	{
		return workersRepository.update(worker.getId(),worker.getFirstname(),worker.getLastname());
	}*/

	
}
