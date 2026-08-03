package com.medicure.backend.doctor.Controller;

import com.medicure.backend.doctor.Entity.doctor;
import com.medicure.backend.doctor.Service.DoctorService;
import com.medicure.backend.doctor.dto.Request.CreateDoctorRequest;
import com.medicure.backend.doctor.dto.Request.UpdateDoctorResquest;
import com.medicure.backend.doctor.dto.Response.DoctorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorResponse> createDoctor(@RequestBody CreateDoctorRequest doctorRequest){
       doctor doctor=  doctorService.createDoctor(doctorRequest);
       if(doctor==null){
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
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
           response.setJoined_date(doctor.getJoined_date());
           response.setUser_id(doctor.getUser_id());

           if (doctor.getDepartment() != null) {
               response.setDepartmentId(doctor.getDepartment().getDepartmentId());
               response.setDepartmentName(doctor.getDepartment().getDepartment_name());
           }
           return new ResponseEntity<>(response,HttpStatus.CREATED);
       }



    @GetMapping
    public ResponseEntity<List<DoctorResponse>> getallDoctors(){
        return  new ResponseEntity<>(doctorService.getAllDoctor(), HttpStatus.FOUND);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DoctorResponse> getDoctorById(@PathVariable Long id){
          return new ResponseEntity<>( doctorService.getDoctorById(id), HttpStatus.FOUND);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<DoctorResponse> updateDoctor(@PathVariable Long id, @RequestBody UpdateDoctorResquest doctorRequest  ){
       return new ResponseEntity<>( doctorService.updateDoctor(id, doctorRequest),HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long id){
        boolean isDeleted =doctorService.deleteDoctor(id);
        if(isDeleted){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);

    }






}
