package com.pack.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pack.project.Entity.Workers;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Long> {
	@Query(value = "SELECT id, username, password, firstname, lastname, address, work_category, prefer_location, gender, number, email, status, profile_image FROM workers WHERE prefer_location = ?1 AND work_category = ?2  AND gender = ?3", nativeQuery = true)
	List<Workers> findWorkers(String location, String category, String gender);

	/*@Query(value = "update ",nativeQuery = true)
	int update(int id,String firstname,String lastname,String address,String phoneno,String worklocation,String workCatogery,String email,String gender);
	*/
}
