package com.medicure.backend.doctor.Service;

import com.medicure.backend.doctor.Entity.doctor;
import com.medicure.backend.doctor.dto.Request.CreateDoctorRequest;
import com.medicure.backend.doctor.dto.Request.UpdateDoctorResquest;
import com.medicure.backend.doctor.dto.Response.DoctorResponse;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface DoctorService {

    public doctor createDoctor(CreateDoctorRequest doctorRequest);
    public DoctorResponse getDoctorById(Long doctorId);
    public DoctorResponse updateDoctor(Long id, UpdateDoctorResquest doctorRequest);
    public boolean deleteDoctor(Long doctorId);
    public List<DoctorResponse>  getAllDoctor();



}
