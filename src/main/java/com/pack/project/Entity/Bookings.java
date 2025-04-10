package com.pack.project.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="bookings")
@Entity
public class Bookings {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private Long userId;
 @Column(name = "worker_id")
 private Long workerId; // or productId
 private LocalDateTime bookingDate;
 private LocalDateTime serviceDate;
 private String status; // BOOKED, CANCELLED, COMPLETED
 private String notes;

 @ManyToOne
 private User user;



 private LocalDateTime createdAt;

private LocalDateTime updatedAt;

public LocalDateTime getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}
public LocalDateTime getUpdatedAt() {
	return updatedAt;
}
public void setUpdatedAt(LocalDateTime updatedAt) {
	this.updatedAt = updatedAt;
}
@Override
public String toString() {
	return "Bookings [id=" + id + ", userId=" + userId + ", workerId=" + workerId + ", bookingDate=" + bookingDate
			+ ", serviceDate=" + serviceDate + ", status=" + status + ", notes=" + notes + "]";
}


}
