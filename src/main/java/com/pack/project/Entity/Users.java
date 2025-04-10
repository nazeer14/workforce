package com.pack.project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usersdata")
public class Users 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "fullname")
	private String fullname;
	@Column(name = "number")
	private String mobileno;
	@Column(name = "password")
	private String password;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", fullname=" + fullname + ", mobileno=" + mobileno + ", password=" + password + "]";
	}
	public Users(long id, String fullname, String mobileno, String password) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.mobileno = mobileno;
		this.password = password;
	}
	public Users() {
		
	}
	
	
}
