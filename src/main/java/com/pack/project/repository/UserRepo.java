package com.pack.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pack.project.Entity.User;

@Repository
public class UserRepo {
	
	@Autowired
	private DataSource ds;
	
	private JdbcTemplate jdbcTemplate;


	public UserRepo(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	private final RowMapper<User> rowMapper = (rs, rowNum) -> 
    new User(rs.getString("username"), rs.getString("password"), null, null,null,null);
	
	public List<User> getUser(User user)
	{
		return jdbcTemplate.query("SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?",rowMapper,
				user.getUsername(),user.getPassword());
	}
	
	 // Add new user
    public int addUser(User user) {
        return jdbcTemplate.update("INSERT INTO USERS VALUES (?, ?, ?, ?, ?, ?)",
                user.getUsername(),user.getPassword(), user.getFirstname(), user.getLastname(), user.getPhoneno(),user.getMail());
    }
    
    public int insert(User user) throws SQLException
    {
    	Connection con=ds.getConnection();
    	PreparedStatement ps=con.prepareStatement("INSERT INTO USERS (username, password, firstname,lastname,phoneno,mail)VALUES (?, ?, ?, ?, ?, ?)");
    	ps.setString(1, user.getUsername());
    	ps.setString(2 , user.getPassword());
    	ps.setString(3 , user.getFirstname());
    	ps.setString(4 , user.getLastname());
    	ps.setLong(5 , user.getPhoneno());
    	ps.setString(6, user.getMail());
    	
    	return ps.executeUpdate();
    }


	

}
