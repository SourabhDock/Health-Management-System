package com.medicure.backend.doctor.dto.Request;

import com.medicure.backend.common.enums.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDoctorResquest {

    @NonNull
    private String Doctor_name;
    private String gender;
    private String phone;
    private String email;
    double consultation_fee;
    @NotBlank
    private String qualification;
    @NotBlank
    private String specialization;
    private int experience_year;
    private Status status;



}

/*

{

"doctor_name":" ",
"phone":" ",
"email":" ",
"qualification":" ",
"experience_year":" ",
"consultation_fee":" ",
"status":" ",

}

 */