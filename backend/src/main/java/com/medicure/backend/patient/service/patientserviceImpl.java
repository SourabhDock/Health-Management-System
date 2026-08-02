package com.medicure.backend.patient.service;

import com.medicure.backend.common.enums.Status;
import com.medicure.backend.patient.PatientEntity.Patient;
import com.medicure.backend.patient.Repository.PatientRepo;
import com.medicure.backend.patient.dto.Request.CreatePatientRequest;
import com.medicure.backend.patient.dto.response.PatientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class patientserviceImpl implements patientservice {



    @Autowired
    private PatientRepo patientRepo;

//create patient complete

    @Override
    public PatientResponse createPatient(CreatePatientRequest request) {
        Patient patient;
        PatientResponse patientResponse;

        if(patientRepo.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        if(patientRepo.existsByPhone(request.getPhone())){
            throw new RuntimeException("Phone already exists");
        }

                patient= new Patient();
                patient.setFirstName(request.getFirst_name());
                patient.setLastName(request.getLast_name());
                patient.setEmail(request.getEmail());
                patient.setPhone(request.getPhone());
                patient.setStatus(Status.ACTIVE);
                // patient = new Patient(1L, request.first_name, request.last_name, null, null, null, request.phone, request.email, null, null, null);
                patientRepo.save(patient);
                patientResponse= new PatientResponse();
                patientResponse.setPatientId(patient.getPatientId());
                patientResponse.setEmail(patient.getEmail());
                patientResponse.setFirst_name(patient.getFirstName());
                patientResponse.setLast_name(patient.getLastName());

                return patientResponse;
    }


    //client->id->check db -> if exist -> create an object of Patient response ->return it

    @Override
    public PatientResponse getPatientById(Long id) {
        if(!patientRepo.existsById(id)){
             throw new RuntimeException("Patient not exist ");
        }


        Patient patient;
        patient= patientRepo.getPatientByPatientId(id);

        PatientResponse patientResponse= new PatientResponse();
        patientResponse.setPatientId(patient.getPatientId());
        patientResponse.setFirst_name(patient.getFirstName());
        patientResponse.setLast_name(patient.getLastName());
        patientResponse.setEmail(patient.getEmail());
        patientResponse.setPhone(patient.getPhone());

        return patientResponse;
    }

    @Override
    public List<PatientResponse> getAllPatients() {
       List<Patient> AllPatient= patientRepo.findAll();

       if(AllPatient.isEmpty() && (AllPatient==null)){
           throw new RuntimeException("No Entries found");
       }
       List<PatientResponse> patientResponseList = new ArrayList<>();
       for(int i=0; i<AllPatient.size();i++){
           PatientResponse patientResponse =new PatientResponse();
           patientResponse.setPatientId(AllPatient.get(i).getPatientId());
           patientResponse.setFirst_name(AllPatient.get(i).getFirstName());
           patientResponse.setLast_name(AllPatient.get(i).getLastName());
           patientResponse.setEmail(AllPatient.get(i).getEmail());
           patientResponse.setPhone(AllPatient.get(i).getPhone());
           patientResponseList.add(patientResponse);
       }
        return patientResponseList;
    }

    @Override
    public PatientResponse updatePatient(Long id, CreatePatientRequest request) {
       Optional<Patient> patient= patientRepo.findById(id);//patient is not entity it is a container that hold reference of entity or null
       if(patient.isEmpty()){
           throw new RuntimeException("USER NOT FOUND");
       }
       patient.get().setFirstName(request.first_name.isEmpty()?patient.get().getFirstName():request.first_name);
       patient.get().setLastName(request.getLast_name().isEmpty()?patient.get().getLastName():request.getLast_name());
       patient.get().setEmail(request.getEmail().isEmpty()?patient.get().getEmail():request.getEmail());
       patient.get().setPhone(request.getPhone().isEmpty()?patient.get().getPhone():request.getPhone());


       patientRepo.save(patient.get());

       PatientResponse patientResponse=new PatientResponse();
       patientResponse.setPatientId(patient.get().getPatientId());
       patientResponse.setPhone(patient.get().getPhone());
       patientResponse.setEmail(patient.get().getEmail());
       patientResponse.setFirst_name(patient.get().getFirstName());
       patientResponse.setLast_name(patient.get().getLastName());


        return patientResponse;
    }

    @Override
    public boolean deletePatientById(Long id) {
        patientRepo.deleteById(id);

        return !(patientRepo.existsById(id));
    }
}
