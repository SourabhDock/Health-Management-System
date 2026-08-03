package com.medicure.backend.doctor.dto.Request;

import com.medicure.backend.department.Entity.department;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Component;



@Component
@Data
public class CreateDoctorRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id;

    private String doctor_name;
    String gender;
    @NotBlank
    String phone;
    @NotBlank
    String email;
    private department department;
    private double consultation_fee;
    private String specialization;
    private String qualification;
    private int experience_year;
}

/*

{

"doctor_name":" ",
"gender":" ",
"phone":" ",
"email":" ",
"specialization":" ",
"qualification":" ",
"experience_year":" ",
"consultation_fee":" ",
"status":" ",




}

 */
