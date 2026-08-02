package com.medicure.backend.department.Repository;

import com.medicure.backend.department.Entity.department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<department, Long> {

    //Defauls methods
    // findAll() findById() save() findAllById() count() existsById() deleteById() delete(T entity) saveAll(Iterable<S> entities)


//    public department getdepartmentByDepartment_name(String depatment_name);
}
