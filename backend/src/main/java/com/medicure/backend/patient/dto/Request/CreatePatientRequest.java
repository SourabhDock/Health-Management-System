package com.medicure.backend.patient.dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePatientRequest {

    @NotBlank(message="First name cannot be blank")
    public  String first_name;
    public String last_name;
    @Email
    @NotBlank(message = "Email is Required")
    public String email;
    @Pattern(
            regexp = "^[6-9]\\{9}$",
            message="Phone is required"
    )
    public String phone;
}
