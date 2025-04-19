package com.pack.project.Entity;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime bookingDate;

    private LocalDateTime createdAt;

    private String notes;

    private LocalDateTime serviceDate;

    private String status;

    private LocalDateTime updatedAt;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus payment;

    // Many bookings can belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    // Many bookings can belong to one worker
    @ManyToOne
    @JoinColumn(name = "worker_id", referencedColumnName = "id")
    private Workers worker;

    // Enum for payment status
    public enum PaymentStatus {
        PENDING,
        PROCESSING,
        COMPLETE,
        FAILED
    }
    
}
