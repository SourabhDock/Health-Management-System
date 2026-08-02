package com.medicure.backend.patient.PatientEntity; // Apne package ka naam yahan likhein

import com.medicure.backend.common.enums.Gender;
import com.medicure.backend.common.enums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "patients") // Table ka naam 'patients' rahega
@Data // Getter, Setter, toString, equals, hashCode automatically generate karta hai
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    // Explicit column names taaki naming strategy ki confusion na ho
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "emergency_contact")
    private String emergencyContact;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    // Ye fields automatically manage hongi
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}