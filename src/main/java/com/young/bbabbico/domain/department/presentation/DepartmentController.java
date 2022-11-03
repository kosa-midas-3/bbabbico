package com.young.bbabbico.domain.department.presentation;

import com.young.bbabbico.domain.department.presentation.dto.response.DepartmentListResponse;
import com.young.bbabbico.domain.department.service.QueryDepartmentListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final QueryDepartmentListService queryDepartmentListService;

    @GetMapping
    public DepartmentListResponse queryDepartmentList() {
        return queryDepartmentListService.execute();
    }
}
