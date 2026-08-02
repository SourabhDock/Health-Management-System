package com.medicure.backend.patient.service;

import com.medicure.backend.patient.PatientEntity.Patient;
import com.medicure.backend.patient.dto.Request.CreatePatientRequest;
import com.medicure.backend.patient.dto.response.PatientResponse;

import java.util.List;

public interface patientservice {

    public PatientResponse createPatient(CreatePatientRequest request);
    public PatientResponse getPatientById(Long id);
    public  List<PatientResponse> getAllPatients();
    public PatientResponse updatePatient(Long id , CreatePatientRequest request);
    public boolean deletePatientById(Long id);
}
