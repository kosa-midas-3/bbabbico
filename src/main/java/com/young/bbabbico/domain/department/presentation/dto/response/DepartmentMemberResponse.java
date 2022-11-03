package com.young.bbabbico.domain.department.presentation.dto.response;

import com.young.bbabbico.domain.attendance.domain.type.WorkingMode;
import com.young.bbabbico.domain.attendance.domain.type.WorkingStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class DepartmentMemberResponse {
    private String name;
    private Boolean isGoneToWork;
    private LocalDateTime startTime;
    private WorkingMode workingMode;
    private WorkingStatus workingStatus;
}
