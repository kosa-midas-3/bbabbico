package com.young.bbabbico.domain.department.service;

import com.young.bbabbico.domain.department.domain.Department;
import com.young.bbabbico.domain.department.domain.repository.DepartmentRepository;
import com.young.bbabbico.domain.department.presentation.dto.response.DepartmentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryDepartmentListService {

    private final DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    public DepartmentListResponse execute() {
        return DepartmentListResponse.builder()
                .departmentList(departmentRepository.findAll().stream()
                        .map(Department::getName).collect(Collectors.toList()))
                .build();
    }
}
