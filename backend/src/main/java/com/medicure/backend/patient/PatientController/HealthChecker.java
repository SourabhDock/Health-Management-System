package com.medicure.backend.patient.PatientController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class HealthChecker {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Welcome to REST API!";
    }

}
