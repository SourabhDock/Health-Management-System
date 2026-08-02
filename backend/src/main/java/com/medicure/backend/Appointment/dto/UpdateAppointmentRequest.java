package com.medicure.backend.Appointment.dto;

import com.medicure.backend.common.enums.APPOINTMENT_STATUS;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class UpdateAppointmentRequest {

    private Long doctorId;

    private Long departmentId;
    private Long patientId;

    @FutureOrPresent(message = "Appointment date cannot be in the past")
    private LocalDateTime AppointmentDateTime;

    private String reason;

    private APPOINTMENT_STATUS status;
}