package com.medicure.backend.doctor.Entity;

import com.medicure.backend.common.enums.Status;
import com.medicure.backend.department.Entity.department;
import jakarta.persistence.*;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Component
@Data
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id;


    private String doctor_name;
    private String gender;

    private String specialization;

    private String qualification;

    private int experience_year;
    private String phone;
    private String email;
    private double consultation_fee;

    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    private LocalDateTime joined_date;
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private department department;
}
