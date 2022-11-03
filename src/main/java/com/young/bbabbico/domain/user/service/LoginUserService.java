package com.young.bbabbico.domain.user.service;

import com.young.bbabbico.domain.attendance.domain.Attendance;
import com.young.bbabbico.domain.attendance.facade.AttendanceFacade;
import com.young.bbabbico.domain.department.domain.Department;
import com.young.bbabbico.domain.department.domain.repository.DepartmentRepository;
import com.young.bbabbico.domain.department.presentation.dto.response.DepartmentResponse;
import com.young.bbabbico.domain.department.presentation.dto.response.DepartmentMemberResponse;
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
    private final DepartmentRepository departmentRepository;

    public UserResponse execute(String name) {
        User user = userFacade.getUserByName(name);
        Attendance attendance = attendanceFacade.getTodayAttendanceByUser(user);


        return UserResponse.builder()
                .name(user.getName())
                .nickname(user.getNickname())
                .startTime(attendance.getCreatedAt())
                .workingStatus(attendance.getWorkingStatus())
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
        Attendance attendance = attendanceFacade.getTodayAttendanceByUser(user);

        return DepartmentMemberResponse.builder()
                .name(user.getName())
                .startTime(attendance.getCreatedAt())
                .workingMode(attendance.getWorkingMode())
                .workingStatus(attendance.getWorkingStatus())
                .build();
    }
}
