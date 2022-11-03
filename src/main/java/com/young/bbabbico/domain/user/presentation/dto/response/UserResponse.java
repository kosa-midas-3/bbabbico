package com.young.bbabbico.domain.user.presentation.dto.response;

import com.young.bbabbico.domain.attendance.domain.type.WorkingMode;
import com.young.bbabbico.domain.attendance.domain.type.WorkingStatus;
import com.young.bbabbico.domain.department.presentation.dto.response.DepartmentResponse;
import com.young.bbabbico.domain.home.domain.type.HomeApplyStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Builder
public class UserResponse {

    private String name;
    private String nickname;
    private HomeApplyStatus homeApplyStatus;
    private String coreStartTime;
    private String coreEndTime;
    private String coreReason;
    private Boolean isGoneToWork;
    private LocalDateTime startTime;
    private WorkingMode workingMode;
    private WorkingStatus workingStatus;
    private DepartmentResponse department;
}
