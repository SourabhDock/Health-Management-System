package com.medicure.backend.common.Entity;

import lombok.Data;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDateTime;

@ComponentScan
@Data
public class user {

    int user_id ;
    String username;
    String password;
    String role;
    String  status;
    LocalDateTime created_at;
    LocalDateTime    updated_at;
}
