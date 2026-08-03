package com.medicure.backend.doctor.Service;

import com.medicure.backend.common.exception.DuplicateResourceException;
import com.medicure.backend.common.exception.GlobalExceptionHandler;
import com.medicure.backend.common.exception.ResourceNotFoundException;
import com.medicure.backend.department.Entity.department;
import com.medicure.backend.department.Repository.DepartmentRepository;
import com.medicure.backend.doctor.Entity.doctor;
import com.medicure.backend.doctor.Repository. DoctorRepository;
import com.medicure.backend.doctor.dto.Request.CreateDoctorRequest ;
import com.medicure.backend.doctor.dto.Request.UpdateDoctorResquest;
import com.medicure.backend.doctor.dto.Response.DoctorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public doctor createDoctor(CreateDoctorRequest doctorRequest) {
        if (doctorRepository.existsByEmail(doctorRequest.getEmail()) || doctorRepository.existsByPhone(doctorRequest.getPhone())) {
            throw new DuplicateResourceException("Doctor email already exists: " + doctorRequest.getEmail() + " or Doctor email already exists: " + doctorRequest.getPhone());
        }

        doctor doctor = new doctor();
        doctor.setDoctor_name(doctorRequest.getDoctor_name());
        doctor.setGender(doctorRequest.getGender());
        doctor.setPhone(doctorRequest.getPhone());
        doctor.setEmail(doctorRequest.getEmail());
        doctor.setConsultation_fee(doctorRequest.getConsultation_fee());
        doctor.setSpecialization(doctorRequest.getSpecialization());
        doctor.setQualification(doctorRequest.getQualification());
        doctor.setStatus(doctor.getStatus());


        // Validate and attach existing Department entity from DB
        if (doctorRequest.getDepartment() != null && doctorRequest.getDepartment().getDepartmentId() != null) {
            department dept = departmentRepository.findById(doctorRequest.getDepartment().getDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found with DeptID :- "
                            + doctorRequest.getDepartment().getDepartmentId()));
            doctor.setDepartment(dept);
        }

        doctorRepository.save(doctor);
        return doctor;
    }

    @Override
    public DoctorResponse getDoctorById(Long doctorId) {
        doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor Not found in system with Doctor ID :- " + doctorId));
        return mapToResponse(doctor);
    }

    @Override
    public DoctorResponse updateDoctor(Long doctorId, UpdateDoctorResquest doctorRequest) {
        doctor existingDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new  ResourceNotFoundException("Doctor Not found in system with Doctor ID :- "+ doctorId));

        existingDoctor.setDoctor_name(doctorRequest.getDoctor_name());
        existingDoctor.setGender(doctorRequest.getGender());
        existingDoctor.setPhone(doctorRequest.getPhone());
        existingDoctor.setEmail(doctorRequest.getEmail());
        existingDoctor.setConsultation_fee(doctorRequest.getConsultation_fee());
        existingDoctor.setQualification(doctorRequest.getQualification());
        existingDoctor.setSpecialization(doctorRequest.getSpecialization());
        existingDoctor.setSpecialization(doctorRequest.getSpecialization());
        existingDoctor.setStatus(doctorRequest.getStatus());


        doctor updatedDoctor = doctorRepository.save(existingDoctor);
        return mapToResponse(updatedDoctor);
    }

    @Override
    public boolean deleteDoctor(Long doctorId) {

        if(doctorRepository.existsById(doctorId)){
            doctorRepository.deleteById(doctorId);
            return true;
        }
        throw new ResourceNotFoundException("Doctor Not found in system with Doctor ID :- " + doctorId);

    }

    @Override
    public List<DoctorResponse> getAllDoctor() {

        List<doctor> doctors = doctorRepository.findAll();

        return doctors.stream()

                .map(this::mapToResponse)

                .collect(Collectors.toList());

    }






    // Helper method to convert Entity -> DTO Response
    private DoctorResponse mapToResponse(doctor doctor) {
        DoctorResponse response = new DoctorResponse();
        response.setDoctor_id(doctor.getDoctor_id());
        response.setDoctor_name(doctor.getDoctor_name());
        response.setGender(doctor.getGender());
        response.setSpecialization(doctor.getSpecialization());
        response.setQualification(doctor.getQualification());
        response.setExperience_year(doctor.getExperience_year());
        response.setPhone(doctor.getPhone());
        response.setEmail(doctor.getEmail());
        response.setConsultation_fee(doctor.getConsultation_fee());
        response.setStatus(doctor.getStatus());



        if (doctor.getDepartment() != null) {
            response.setDepartmentId(doctor.getDepartment().getDepartmentId());
            response.setDepartmentName(doctor.getDepartment().getDepartment_name());
        }

        return response;
    }
}