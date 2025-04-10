package com.pack.project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@Column(unique = true,nullable = false)
	private String username;
	@Column(nullable = false, length = 100)
	private String password;
	@Column(nullable = false, length =50)
	private String firstname;
	@Column(nullable = false, length = 50)
	private String lastname;
	@Column(unique = true,nullable = false)
	private Long phoneno;
	@Column(unique = true,nullable = false)
	private String mail;
	
	public User(String username, String password, String firstname, String lastname, Long phoneno, String mail) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneno = phoneno;
		this.mail = mail;
	}
	
	public User()
	{
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", phoneno=" + phoneno + ", mail=" + mail + "]";
	}
	
	
	
}
