package com.medicure.backend.Appointment.Controller;

import com.medicure.backend.Appointment.Service.AppointmentService;
import com.medicure.backend.Appointment.dto.AppointmentResponse;
import com.medicure.backend.Appointment.dto.CreateAppointmentRequest;
import com.medicure.backend.Appointment.dto.UpdateAppointmentRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<AppointmentResponse> createAppointment(
            @Valid @RequestBody CreateAppointmentRequest request) {

        AppointmentResponse response = appointmentService.createAppointment(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResponse> getAppointmentById(
            @PathVariable Long appointmentId) {

        AppointmentResponse response =
                appointmentService.getAppointmentById(appointmentId);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {

        List<AppointmentResponse> response =
                appointmentService.getAllAppointments();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResponse> updateAppointment(
            @PathVariable Long appointmentId,
            @RequestBody @Valid UpdateAppointmentRequest request) {

        AppointmentResponse response =
                appointmentService.updateAppointment(appointmentId, request);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{appointmentId}/confirm")
    public ResponseEntity<AppointmentResponse> confirmAppointment(
            @PathVariable Long appointmentId) {

        return ResponseEntity.ok(
                appointmentService.confirmAppointment(appointmentId)
        );
    }

    @PutMapping("/{appointmentId}/cancel")
    public ResponseEntity<AppointmentResponse> cancelAppointment(
            @PathVariable Long appointmentId) {

        return ResponseEntity.ok(
                appointmentService.cancelAppointment(appointmentId)
        );
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByPatient(
            @PathVariable Long patientId) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsByPatient(patientId)
        );
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<AppointmentResponse>> getAppointmentsByDoctor(
            @PathVariable Long doctorId) {

        return ResponseEntity.ok(
                appointmentService.getAppointmentsByDoctor(doctorId)
        );
    }
}
