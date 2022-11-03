package com.young.bbabbico.domain.attendance.facade;

import com.young.bbabbico.domain.attendance.domain.Attendance;
import com.young.bbabbico.domain.attendance.domain.repository.AttendanceRepository;
import com.young.bbabbico.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class AttendanceFacade {

    private final AttendanceRepository attendanceRepository;

    @Transactional(readOnly = true)
    public Attendance getTodayAttendanceByUser(User user) {
        return attendanceRepository.findByUserAndDate(user, LocalDate.now())
                .orElseThrow(() -> new IllegalArgumentException("출근하지 않은 사용자입니다."));
    }

    @Transactional(readOnly = true)
    public Attendance getTodayNullableAttendanceByUser(User user) {
        return attendanceRepository.findAttendanceByUserAndDate(user, LocalDate.now());
    }
}
