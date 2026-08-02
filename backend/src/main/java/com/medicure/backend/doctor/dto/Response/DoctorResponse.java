package com.medicure.backend.doctor.dto.Response;

import lombok.Data;
import java.time.LocalDate;

@Data
public class DoctorResponse {
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
    private Long departmentId;
    private String departmentName;
}