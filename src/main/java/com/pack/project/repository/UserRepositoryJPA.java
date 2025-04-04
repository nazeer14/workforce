package com.pack.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pack.project.Entity.User;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, String> {
	@Query(value = "SELECT USERNAME,PASSWORD,FIRSTNAME,LASTNAME,PHONENO,MAIL FROM users WHERE username = :username and password= :password", nativeQuery = true)
	 User validate(@Param("username") String username,@Param("password") String password);
	
	@Query(value="SELECT USERNAME,PASSWORD,FIRSTNAME,LASTNAME,PHONENO,MAIL FROM USERS WHERE mail= :mail or phoneno= :phoneno",nativeQuery = true)
	User forgot(@Param("mail") String mail,@Param("phoneno")Long phoneno);
}
