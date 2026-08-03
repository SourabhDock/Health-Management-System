package com.medicure.backend.department.Entity;


import com.medicure.backend.doctor.Entity.doctor;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;



@Component
@Data
@NoArgsConstructor
@Entity
public class department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    @NotBlank
    private String department_name;
    private String description;
    @Column(columnDefinition = " varchar(50) default 'Active'")
    private String status;

    @OneToMany( mappedBy = "department")

    private List<doctor> doctorList;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime CreatedAt;
    @UpdateTimestamp
    private LocalDateTime Updated_at;

}

/*

{
"department_name":" ",
"description": " ",
"status": " ",
"doctor_list":" ",

}
 */

