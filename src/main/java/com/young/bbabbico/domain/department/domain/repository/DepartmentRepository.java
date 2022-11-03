package com.young.bbabbico.domain.department.domain.repository;

import com.young.bbabbico.domain.department.domain.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

    Optional<Department> findByName(String name);
}
