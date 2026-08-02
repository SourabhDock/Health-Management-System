package com.medicure.backend.patient.PatientController;



import com.medicure.backend.patient.Repository.PatientRepo;
import com.medicure.backend.patient.dto.Request.CreatePatientRequest;
import com.medicure.backend.patient.dto.response.PatientResponse;
import com.medicure.backend.patient.service.patientservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private patientservice patientservice;



    @PostMapping
    public String saveall(@RequestBody CreatePatientRequest patient){
        patientservice.createPatient(patient);
        return "ok";
    }




    @GetMapping
    public List<PatientResponse> getall(){
        return patientservice.getAllPatients();
    }

    @GetMapping("/id/{id}")
    public PatientResponse getPatientById(@PathVariable Long id ){

        return patientservice.getPatientById(id);
    }

    @PutMapping("/{id}")
    public  PatientResponse updatePatiet(@PathVariable Long id, @RequestBody CreatePatientRequest request){
        return patientservice.updatePatient(id,request);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id ){
        return patientservice.deletePatientById(id);
    }



}



