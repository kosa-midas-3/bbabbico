package com.young.bbabbico.domain.user.presentation.dto.response;

import com.young.bbabbico.domain.attendance.domain.type.WorkingMode;
import com.young.bbabbico.domain.attendance.domain.type.WorkingStatus;
import com.young.bbabbico.domain.department.presentation.dto.response.DepartmentResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserResponse {

    private String name;
    private String nickname;
    private Boolean isGoneToWork;
    private LocalDateTime startTime;
    private WorkingMode workingMode;
    private WorkingStatus workingStatus;
    private DepartmentResponse department;
}
