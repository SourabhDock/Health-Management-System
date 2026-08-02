package com.medicure.backend.Appointment.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateAppointmentRequest {

    @NotNull(message = "Patient Id is required")
    private Long patientId;

    @NotNull(message = "Doctor Id is required")
    private Long doctorId;

    @NotNull(message = "Department Id is required")
    private Long departmentId;

    @NotNull(message = "Appointment date & Time is required")
    @FutureOrPresent(message = "Appointment date cannot be in the past")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime AppointmentDateTime;




    @NotBlank(message = "Reason is required")
    private String reason;
}