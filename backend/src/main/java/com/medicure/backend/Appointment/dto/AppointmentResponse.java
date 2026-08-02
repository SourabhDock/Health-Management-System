package com.medicure.backend.Appointment.dto;

import com.medicure.backend.common.enums.APPOINTMENT_STATUS;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class AppointmentResponse {

    private Long appointmentId;

    private Long patientId;

    private String patientName;

    private Long doctorId;

    private String doctorName;

    private Long departmentId;

    private String departmentName;

    private LocalDateTime AppointmentDateTime;

    private String reason;

    private APPOINTMENT_STATUS status;
}