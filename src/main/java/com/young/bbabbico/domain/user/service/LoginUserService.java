package com.young.bbabbico.domain.user.service;

import com.young.bbabbico.domain.attendance.domain.Attendance;
import com.young.bbabbico.domain.attendance.facade.AttendanceFacade;
import com.young.bbabbico.domain.coretime.domain.CoreTime;
import com.young.bbabbico.domain.coretime.facade.CoreTimeFacade;
import com.young.bbabbico.domain.department.domain.Department;
import com.young.bbabbico.domain.department.domain.repository.DepartmentRepository;
import com.young.bbabbico.domain.department.presentation.dto.response.DepartmentMemberResponse;
import com.young.bbabbico.domain.department.presentation.dto.response.DepartmentResponse;
import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.facade.UserFacade;
import com.young.bbabbico.domain.user.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginUserService {

    private final UserFacade userFacade;
    private final AttendanceFacade attendanceFacade;
    private final CoreTimeFacade coreTimeFacade;
    private final DepartmentRepository departmentRepository;

    public UserResponse execute(String name) {
        User user = userFacade.getUserByName(name);
        Attendance attendance = attendanceFacade.getTodayNullableAttendanceByUser(user);
        CoreTime coreTime = coreTimeFacade.getTodayNullableCoreTimeByUser(user);

        return UserResponse.builder()
                .name(user.getName())
                .nickname(user.getNickname())
                .coreStartTime(coreTime != null ? coreTime.getStartTime() : null)
                .coreEndTime(coreTime != null ? coreTime.getEndTime() : null)
                .isGoneToWork(attendance != null)
                .startTime(attendance != null ? attendance.getCreatedAt() : null)
                .workingMode(attendance != null ? attendance.getWorkingMode() : null)
                .workingStatus(attendance != null ? attendance.getWorkingStatus() : null)
                .department(getDepartment(user.getDepartment()))
                .build();
    }

    private DepartmentResponse getDepartment(Department department) {
        return DepartmentResponse.builder()
                .department(department.getName())
                .members(getDepartmentMembers(department))
                .build();
    }

    private List<DepartmentMemberResponse> getDepartmentMembers(Department department) {
        return departmentRepository.findDepartmentMembers(department)
                .stream()
                .map(this::createDepartmentMemberResponse)
                .collect(Collectors.toList());
    }

    private DepartmentMemberResponse createDepartmentMemberResponse(User user) {
        Attendance attendance = attendanceFacade.getTodayNullableAttendanceByUser(user);

        return DepartmentMemberResponse.builder()
                .name(user.getName())
                .nickname(user.getNickname())
                .isGoneToWork(attendance != null)
                .startTime(attendance != null ? attendance.getCreatedAt() : null)
                .workingMode(attendance != null ? attendance.getWorkingMode() : null)
                .workingStatus(attendance != null ? attendance.getWorkingStatus() : null)
                .build();
    }
}
