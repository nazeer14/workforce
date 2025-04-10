package com.pack.project.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WORKERS")
public class Workers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = false,length = 100)
    private String username;
    @Column(nullable = false,length = 100)
    private String password;
    @Column(nullable = false,length = 100)
    private String firstname;
    @Column(nullable = true,length = 100)
    private String lastname;
    @Column(nullable = true,length = 100)
    private String address;
    @JsonProperty("workCategory")
    @Column(name = "work_category",length = 50,nullable = false)
    private String workCategory;
    @JsonProperty("preferedLocation")
    @Column(name = "prefer_location",length = 50,nullable = false)
    private String preferedLocation; // Make sure this matches the column or use @JsonProperty
    @Column(nullable = false,length = 25)
    private String gender;
    @Column(unique = false,nullable = true,length = 15)
    private String number;
    @Column(nullable = true,length = 100)
    private String email;
    @Column(nullable = false,length = 100)
	private String status;
	 @Column(name = "profile_image",length = 200,nullable = true)
    private String profileImage;
    
    @Override
	public String toString() {
		return "Workers [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", address=" + address + ", workCategory=" + workCategory
				+ ", preferedLocation=" + preferedLocation + ", gender=" + gender + ", number=" + number + ", email="
				+ email + ", status=" + status + ", profileImage=" + profileImage + "]";
	}
    
    public Workers(long id, String username, String password, String firstname, String lastname, String address,
			String workCategory, String preferedLocation, String gender, String number, String email, String status,
			String profileImage) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.workCategory = workCategory;
		this.preferedLocation = preferedLocation;
		this.gender = gender;
		this.number = number;
		this.email = email;
		this.status = status;
		this.profileImage = profileImage;
	}

    
	public Workers() {
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWorkCategory() {
		return workCategory;
	}
	public void setWorkCategory(String workCategory) {
		this.workCategory = workCategory;
	}
	public String getPreferedLocation() {
		return preferedLocation;
	}
	public void setPreferedLocation(String preferedLocation) {
		this.preferedLocation = preferedLocation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNumber() {
		return number;
	}

    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	

    // Getters and setters
}
