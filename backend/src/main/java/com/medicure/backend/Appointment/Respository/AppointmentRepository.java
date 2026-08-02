package com.medicure.backend.Appointment.Respository;

import com.medicure.backend.Appointment.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByDoctorId(Long doctorId);
//        boolean existsByDoctorIdAndAppointmentDateTime(
//                Long doctorId,
//                LocalDateTime appointmentDateTime
//        );
    }

