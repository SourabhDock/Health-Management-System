package com.medicure.backend.department.Service;

import com.medicure.backend.department.Entity.department;
import com.medicure.backend.department.dto.Response.DepartmentResponse;
import com.medicure.backend.doctor.dto.Response.DoctorResponse;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface DepartmentService {

    public List<DepartmentResponse>  getAllDepartment();
    public DepartmentResponse getDepartmentById(Long id);
    public  DepartmentResponse createDepartment(department department);
    public  DepartmentResponse updateDepartment( Long id ,department department);
    public  boolean deleteDepartment(Long id);
    public List<DoctorResponse> getDoctorByDepartmentId(Long id);

}
