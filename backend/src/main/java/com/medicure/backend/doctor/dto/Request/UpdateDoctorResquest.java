package com.medicure.backend.doctor.dto.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

import java.time.LocalDate;

public class UpdateDoctorResquest {

    @NonNull
    String doctor_name;
    String gender;
    @NotBlank
    String specialization;
    @NotBlank
    String qualification;

    int experience_year;
    String phone;
    String email;
    double consultation_fee;
    String status;




}
