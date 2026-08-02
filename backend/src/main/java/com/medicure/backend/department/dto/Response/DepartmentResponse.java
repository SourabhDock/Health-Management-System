package com.medicure.backend.department.dto.Response;


import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@Data
@NoArgsConstructor
public class DepartmentResponse {
    @Id
    Long department_id;
    @NotBlank
    String department_name;
    String description;

    String status;


}
