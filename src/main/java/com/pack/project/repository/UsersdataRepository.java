package com.pack.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pack.project.Entity.Users;

import jakarta.transaction.Transactional;


@Repository
public interface UsersdataRepository extends JpaRepository<Users, Long> {

	@Query(value = "select id,fullname,number,password from usersdata where id= :id",nativeQuery = true)
	Users getByUserId(@Param("id") long id);
	
	@Query(value = "SELECT * FROM usersdata WHERE number = :number AND password = :password", nativeQuery = true)
	Users validate(@Param("number") String number, @Param("password") String password);
	
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE usersdata SET password = :password WHERE number = :number", nativeQuery = true)
	int updatePassword( @Param("number") String phoneNumber,@Param("password") String password);


}
