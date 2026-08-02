package com.medicure.backend.Appointment.Service;

import com.medicure.backend.Appointment.dto.AppointmentResponse;
import com.medicure.backend.Appointment.dto.CreateAppointmentRequest;
import com.medicure.backend.Appointment.dto.UpdateAppointmentRequest;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface AppointmentService {
   public AppointmentResponse createAppointment(CreateAppointmentRequest Request);

    public AppointmentResponse getAppointmentById(Long id);

    public List<AppointmentResponse> getAllAppointments();

    public AppointmentResponse updateAppointment( Long appointmentId,
                                                  UpdateAppointmentRequest request);

    public AppointmentResponse cancelAppointment(Long appointmentId);

    public AppointmentResponse confirmAppointment(Long appointmentId);

    public List<AppointmentResponse> getAppointmentsByPatient(Long patientId);;

    public List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId);;
}
