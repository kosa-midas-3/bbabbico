package com.young.bbabbico.domain.department.domain.repository;

import com.young.bbabbico.domain.department.domain.Department;
import com.young.bbabbico.domain.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

    Optional<Department> findByName(String name);

    @Query("SELECT m FROM User m WHERE m.department = :department")
    List<User> findDepartmentMembers(Department department);

    List<Department> findAll();
}
