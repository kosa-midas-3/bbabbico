package com.young.bbabbico.domain.department.facade;

import com.young.bbabbico.domain.department.domain.Department;
import com.young.bbabbico.domain.department.domain.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DepartmentFacade {

    private final DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("부서가 없습니다."));
    }
}
