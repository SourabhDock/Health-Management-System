package com.medicure.backend.Appointment.Entity;


import com.medicure.backend.common.enums.APPOINTMENT_STATUS;
import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointment_id ;
    private Long patientId;
    private Long doctorId;
    private Long departmentId;
    private Long receptionistId;
    private LocalDateTime appointment_dateTime;

    private APPOINTMENT_STATUS status;
    private String  reason;
    private LocalDateTime verified_at;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;




}
