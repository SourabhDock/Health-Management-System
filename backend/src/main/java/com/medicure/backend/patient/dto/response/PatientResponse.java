package com.medicure.backend.patient.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PatientResponse {

    private Long patientId;

    private String first_name;
    private String last_name;
    private String phone;
    private String email;

}

/*

{

 */