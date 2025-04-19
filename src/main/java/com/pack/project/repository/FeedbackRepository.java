package com.pack.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pack.project.Entity.Feedbacks;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedbacks, String>{
	
	List<Feedbacks> findByUserid(String userid);

}
