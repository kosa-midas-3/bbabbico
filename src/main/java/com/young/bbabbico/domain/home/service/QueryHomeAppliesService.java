package com.young.bbabbico.domain.home.service;

import com.young.bbabbico.domain.attendance.domain.Attendance;
import com.young.bbabbico.domain.attendance.domain.type.WorkingStatus;
import com.young.bbabbico.domain.attendance.facade.AttendanceFacade;
import com.young.bbabbico.domain.home.domain.HomeApply;
import com.young.bbabbico.domain.home.domain.type.HomeApplyStatus;
import com.young.bbabbico.domain.home.facade.HomeApplyFacade;
import com.young.bbabbico.domain.home.presentation.dto.response.HomeApplyListResponse;
import com.young.bbabbico.domain.home.presentation.dto.response.HomeApplyResponse;
import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.domain.repository.UserRepository;
import com.young.bbabbico.domain.user.domain.type.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryHomeAppliesService {

    private final UserRepository userRepository;
    private final AttendanceFacade attendanceFacade;
    private final HomeApplyFacade homeApplyFacade;

    @Transactional(readOnly = true)
    public HomeApplyListResponse execute() {
        return HomeApplyListResponse.builder()
                .homeApplies(getGroupByDepartment())
                .build();
    }

    private Map<String, List<HomeApplyResponse>> getGroupByDepartment() {
        return userRepository.findUsersByAuthority(Authority.USER)
                .stream()
                .map(this::createHomeApplyResponse)
                .collect(Collectors.groupingBy(HomeApplyResponse::getDepartment));
    }

    private HomeApplyResponse createHomeApplyResponse(User user) {
        Attendance attendance = attendanceFacade.getTodayNullableAttendanceByUser(user);
        HomeApply homeApply = homeApplyFacade.getNullableHomeApplyByUser(user);

        return HomeApplyResponse.builder()
                .userId(user.getId())
                .name(user.getName())
                .nickname(user.getNickname())
                .isGoneToWork(attendance != null)
                .startTime(attendance != null ? attendance.getCreatedAt() : null)
                .endTime(attendance != null && attendance.getWorkingStatus() == WorkingStatus.LEAVE ? attendance.getUpdatedAt() : null)
                .workingMode(attendance != null ? attendance.getWorkingMode() : null)
                .workingStatus(attendance != null ? attendance.getWorkingStatus() : null)
                .department(user.getDepartment().getName())
                .homeApplyId(homeApply != null ? homeApply.getId() : null)
                .homeApplyStatus(homeApply != null ? homeApply.getHomeApplyStatus() : HomeApplyStatus.NOTHING)
                .build();
    }
}
