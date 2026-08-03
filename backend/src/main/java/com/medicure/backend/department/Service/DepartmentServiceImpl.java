package com.medicure.backend.department.Service;

import com.medicure.backend.department.Entity.department;
import com.medicure.backend.department.Repository.DepartmentRepository;
import com.medicure.backend.department.dto.Response.DepartmentResponse;
import com.medicure.backend.doctor.Entity.doctor;
import com.medicure.backend.doctor.dto.Response.DoctorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements  DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;




    @Override
    public  List<DepartmentResponse> getAllDepartment(){
        List<department> departmentList= departmentRepository.findAll();
        List<DepartmentResponse> departmentResponseList= new ArrayList<>();
        for(department e:departmentList){
            DepartmentResponse departmentResponse= new DepartmentResponse();
            departmentResponse.setDepartment_id(e.getDepartmentId());
            departmentResponse.setDepartment_name(e.getDepartment_name());
            departmentResponse.setDescription(e.getDescription());
            departmentResponse.setStatus(e.getStatus());
            departmentResponseList.add(departmentResponse);

        }
        return departmentResponseList;
    }


    @Override
    public DepartmentResponse getDepartmentById(Long id) {
        Optional<department> department= departmentRepository.findById( id);
        if(department.isEmpty() ){
            throw new RuntimeException("Entity not found");
        }
        DepartmentResponse departmentResponse =new DepartmentResponse();
        departmentResponse.setDepartment_id(department.get().getDepartmentId());
        departmentResponse.setDepartment_name(department.get().getDepartment_name());
        departmentResponse.setDescription(department.get().getDescription());
        departmentResponse.setStatus(department.get().getStatus());

        return departmentResponse;
    }

    @Override
    public DepartmentResponse createDepartment( department department) {
        department department1= new department();
        department1.setDepartment_name(department.getDepartment_name());
        department1.setDescription(department.getDescription());

        departmentRepository.save(department1);

        DepartmentResponse departmentResponse= new DepartmentResponse();
        departmentResponse.setDepartment_id(department1.getDepartmentId());
        departmentResponse.setDepartment_name(department.getDepartment_name());
        departmentResponse.setDescription(department1.getDescription());
        departmentResponse.setStatus(department1.getStatus());

        return departmentResponse;
    }

    @Override
    public DepartmentResponse updateDepartment(Long id ,department department) {

        Optional<department> department1= departmentRepository.findById(id);
        if(department1.isEmpty() ){
            throw new RuntimeException("Department not found");
        }
        department1.get().setDepartment_name(department.getDepartment_name().isEmpty() ? department1.get().getDepartment_name(): department.getDepartment_name());
        department1.get().setDescription(department.getDescription().isBlank() ? department1.get().getDescription() : department.getDescription());
        department1.get().setStatus(department.getStatus().isBlank()? department1.get().getStatus(): department.getStatus());

        departmentRepository.save(department1.get());
        DepartmentResponse departmentResponse= new DepartmentResponse();
        departmentResponse.setDepartment_id(department1.get().getDepartmentId());
        departmentResponse.setDepartment_name(department1.get().getDepartment_name());
        departmentResponse.setDescription(department1.get().getDescription());
        departmentResponse.setStatus(department1.get().getStatus());
        return departmentResponse;
    }

    @Override
    public boolean deleteDepartment(Long id) {
        boolean isAvailable= departmentRepository.existsById(id);
        if(isAvailable){
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<DoctorResponse> getDoctorByDepartmentId(Long id) {
        Optional<department> department = departmentRepository.findById(id);
        if(department.isEmpty()){
            throw new RuntimeException("New Department found for such ID");
        }

        List<DoctorResponse> doctorResponseList = new ArrayList<>();

        List<doctor> doctorList= department.get().getDoctorList();
        for(doctor e:doctorList){
            DoctorResponse doctorResponse= new DoctorResponse();
            doctorResponse.setDoctor_id(e.getDoctor_id());
            doctorResponse.setDoctor_name(e.getDoctor_name());
            doctorResponse.setSpecialization(e.getSpecialization());
            doctorResponse.setExperience_year(e.getExperience_year());
            doctorResponse.setConsultation_fee(e.getConsultation_fee());
            doctorResponse.setStatus(e.getStatus());

            doctorResponseList.add(doctorResponse);
        }



        return doctorResponseList;
    }
}
