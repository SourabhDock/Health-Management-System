package com.medicure.backend.patient.Repository;

import com.medicure.backend.patient.PatientEntity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {

    public Patient getPatientByPatientId(Long id) ;

    public Patient findByEmail(String email);

    public Patient findByPhone(String phone);

    public boolean existsByEmail(String email);

    public boolean existsByPhone(String phone);
}
