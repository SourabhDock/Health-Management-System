package com.medicure.backend.doctor.Entity;

import com.medicure.backend.department.Entity.department;
import jakarta.persistence.*;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
@Data
@NoArgsConstructor
@Entity
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
    private String status;
    private LocalDate joined_date;
    private int user_id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private department department;
}
