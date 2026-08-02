package com.medicure.backend.Receptionist.Entity;

import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;

@ComponentScan
@Data
public class Receptionist {
    int receptionist_id;
    int user_id;
    String first_name;
    String last_name;
    int phone;
    String email;
    String status;
    LocalDateTime joined_at;
    LocalDateTime updated_at;
}



