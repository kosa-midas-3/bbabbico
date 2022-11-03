package com.young.bbabbico.domain.home.presentation.dto.response;

import com.young.bbabbico.domain.attendance.domain.type.WorkingMode;
import com.young.bbabbico.domain.attendance.domain.type.WorkingStatus;
import com.young.bbabbico.domain.home.domain.type.HomeApplyStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class HomeApplyResponse {

    private Long userId;
    private String name;
    private String nickname;
    private Boolean isGoneToWork;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private WorkingMode workingMode;
    private WorkingStatus workingStatus;
    private String department;
    private Long homeApplyId;
    private HomeApplyStatus homeApplyStatus;
}
