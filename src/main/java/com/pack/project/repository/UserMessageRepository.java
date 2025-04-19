package com.pack.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pack.project.Entity.UserMessage;

@Repository
public interface UserMessageRepository extends MongoRepository<UserMessage, String> {
		
		List<UserMessage> findByuserid(String userid);
}
