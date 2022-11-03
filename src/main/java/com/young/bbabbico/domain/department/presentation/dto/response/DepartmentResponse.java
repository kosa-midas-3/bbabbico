package com.young.bbabbico.domain.department.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class DepartmentResponse {

    private String department;
    private List<DepartmentMemberResponse> members;
}