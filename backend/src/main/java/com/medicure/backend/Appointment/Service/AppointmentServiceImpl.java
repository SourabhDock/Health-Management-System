package com.medicure.backend.Appointment.Service;

import com.medicure.backend.Appointment.Entity.Appointment;
import com.medicure.backend.Appointment.Respository.AppointmentRepository;
import com.medicure.backend.Appointment.dto.AppointmentResponse;
import com.medicure.backend.Appointment.dto.CreateAppointmentRequest;
import com.medicure.backend.Appointment.dto.UpdateAppointmentRequest;
import com.medicure.backend.common.enums.APPOINTMENT_STATUS;
import com.medicure.backend.department.Repository.DepartmentRepository;
import com.medicure.backend.doctor.Repository.DoctorRepository;
import com.medicure.backend.patient.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    DoctorRepository doctorRepo;

    @Autowired
    DepartmentRepository departmentRepo;

    @Autowired
    AppointmentRepository appointmentRepo;

    @Override
    public AppointmentResponse createAppointment(CreateAppointmentRequest request) {

        // Check Patient
        if (!patientRepo.existsById(request.getPatientId())) {
            throw new RuntimeException("Patient not found.");
        }

        // Check Doctor
        if (!doctorRepo.existsById(request.getDoctorId())) {
            throw new RuntimeException("Doctor not found.");
        }

        // Check Department
        if (!departmentRepo.existsById(request.getDepartmentId())) {
            throw new RuntimeException("Department not found.");
        }

        Appointment appointment = new Appointment();

        appointment.setPatientId(request.getPatientId());
        appointment.setDoctorId(request.getDoctorId());
        appointment.setDepartmentId(request.getDepartmentId());
        appointment.setAppointment_dateTime(request.getAppointmentDateTime());
        appointment.setReason(request.getReason());

        appointment.setStatus(APPOINTMENT_STATUS.PENDING);

        appointment.setCreated_at(LocalDateTime.now());

        appointment = appointmentRepo.save(appointment);



        return mapToResponse(appointment);
    }

    @Override
    public AppointmentResponse getAppointmentById(Long appointmentId) {

        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

         return mapToResponse(appointment);
    }

    @Override
    public List<AppointmentResponse> getAllAppointments() {

        List<Appointment> appointments = appointmentRepo.findAll();

        List<AppointmentResponse> responseList = new ArrayList<>();

        for (Appointment appointment : appointments) {
            responseList.add(mapToResponse(appointment));
        }

        return responseList;
    }

    @Override
    public AppointmentResponse updateAppointment(Long appointmentId,
                                                 UpdateAppointmentRequest request) {

        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Patient Exists
        if (!patientRepo.existsById(request.getPatientId())) {
            throw new RuntimeException("Patient not found");
        }

        // Doctor Exists
        if (!doctorRepo.existsById(request.getDoctorId())) {
            throw new RuntimeException("Doctor not found");
        }

        // Department Exists
        if (!departmentRepo.existsById(request.getDepartmentId())) {
            throw new RuntimeException("Department not found");
        }

        // Update Fields
        appointment.setPatientId(request.getPatientId());
        appointment.setDoctorId(request.getDoctorId());
        appointment.setDepartmentId(request.getDepartmentId());
        appointment.setAppointment_dateTime(request.getAppointmentDateTime());
        appointment.setReason(request.getReason());

        appointment.setUpdated_at(LocalDateTime.now());

        appointment = appointmentRepo.save(appointment);

        return mapToResponse(appointment);
    }

    @Override
    public AppointmentResponse cancelAppointment(Long appointmentId) {

        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus(APPOINTMENT_STATUS.CANCELLED);

        appointment = appointmentRepo.save(appointment);

        return mapToResponse(appointment);
    }

    @Override
    public AppointmentResponse confirmAppointment(Long appointmentId) {

        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus(APPOINTMENT_STATUS.CONFIRMED);
        appointment.setVerified_at(LocalDateTime.now());

        appointment = appointmentRepo.save(appointment);

        return mapToResponse(appointment);
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByPatient(Long patientId) {

        List<Appointment> appointments =
                appointmentRepo.findByPatientId(patientId);

        List<AppointmentResponse> response = new ArrayList<>();

        for (Appointment appointment : appointments) {
            response.add(mapToResponse(appointment));
        }

        return response;
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId) {

        List<Appointment> appointments =
                appointmentRepo.findByDoctorId(doctorId);

        List<AppointmentResponse> response = new ArrayList<>();

        for (Appointment appointment : appointments) {
            response.add(mapToResponse(appointment));
        }

        return response;
    }


    private AppointmentResponse mapToResponse(Appointment appointment) {

        AppointmentResponse response = new AppointmentResponse();

        response.setAppointmentId(appointment.getAppointment_id());
        response.setPatientId(appointment.getPatientId());
        response.setDoctorId(appointment.getDoctorId());
        response.setDepartmentId(appointment.getDepartmentId());
        response.setAppointmentDateTime(appointment.getAppointment_dateTime());
        response.setReason(appointment.getReason());
        response.setStatus(appointment.getStatus());

        return response;
    }
}
