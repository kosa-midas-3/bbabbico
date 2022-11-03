package com.young.bbabbico.domain.attendance.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AttendanceListResponse {

    private List<Long> days;
}
