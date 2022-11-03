package com.young.bbabbico.domain.attendance.service;

import com.young.bbabbico.domain.attendance.domain.Attendance;
import com.young.bbabbico.domain.attendance.domain.repository.AttendanceRepository;
import com.young.bbabbico.domain.attendance.facade.AttendanceFacade;
import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class LeaveWorkService {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceFacade attendanceFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(String name) {
        User user = userFacade.getUserByName(name);
        Attendance attendance = attendanceFacade.getTodayAttendanceByUser(user);
        attendance.leave();
    }
}
