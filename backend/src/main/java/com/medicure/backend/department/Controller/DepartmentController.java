package com.medicure.backend.department.Controller;


import com.medicure.backend.department.Entity.department;
import com.medicure.backend.department.Service.DepartmentService;
import com.medicure.backend.department.dto.Response.DepartmentResponse;

import com.medicure.backend.doctor.dto.Response.DoctorResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments(){
        List<DepartmentResponse> departmentList=  departmentService.getAllDepartment();
        return  new ResponseEntity<>(departmentList,HttpStatus.FOUND);

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable Long id){
        DepartmentResponse departmentResponse= departmentService.getDepartmentById(id);
        return new ResponseEntity<>(departmentResponse, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody department department){
        DepartmentResponse result= departmentService.createDepartment(department);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Long id, @RequestBody department department ){
       DepartmentResponse departmentResponse= departmentService.updateDepartment(id, department);
        return new ResponseEntity<>(departmentResponse, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?>  deleteDepartment(@PathVariable Long id ){
       boolean result= departmentService.deleteDepartment(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/departmentid/{id}")
    public ResponseEntity<List<DoctorResponse>> getDoctorByDepartmentId(@PathVariable Long id){
        List<DoctorResponse> doctorResponsesList= departmentService.getDoctorByDepartmentId(id);

        return  new ResponseEntity<>(doctorResponsesList, HttpStatus.FOUND);
    }





}
