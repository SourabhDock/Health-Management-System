package com.medicure.backend.doctor.dto.Response;

import com.medicure.backend.common.enums.Status;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;

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
    private Status status;
    private Long departmentId;
    private String departmentName;
}