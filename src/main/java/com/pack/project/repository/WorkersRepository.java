package com.pack.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pack.project.Entity.Workers;

import jakarta.transaction.Transactional;

@Repository
public interface WorkersRepository extends JpaRepository<Workers, Long> {
	@Query(value = "SELECT id, number, password, firstname, lastname, address, work_category, prefer_location, gender, email, status, profile_image FROM workers WHERE prefer_location = ?1 AND work_category = ?2  AND gender = ?3 AND status='ON'", nativeQuery = true)
	List<Workers> findWorkers(String location, String category, String gender);

	/*@Query(value = "update ",nativeQuery = true)
	int update(int id,String firstname,String lastname,String address,String phoneno,String worklocation,String workCatogery,String email,String gender);
	*/
	
	@Query(value = "select * from workers where number= ?1 and password= ?2",nativeQuery = true)
	Workers login(String number,String password);
	
	@Modifying
	@Transactional
	@Query(value = "update workers set firstname= ?1,lastname= ?2,address= ?3,gender= ?4,work_category =?5, prefer_location=?6, email=?7, profile_image=?8, status=?9 where id= ?10",nativeQuery = true)
	int profileUpdate(String firstname,String lastname,String address,String gender,String category,String location,String mail,String imageurl,String status,long id);
}
