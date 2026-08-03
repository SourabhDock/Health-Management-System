package com.medicure.backend.doctor.Repository;

import com.medicure.backend.doctor.Entity.doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<doctor, Long> {


    public boolean existsByEmail(String email);
    public boolean existsByPhone(String phone);
}
