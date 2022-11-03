package com.young.bbabbico.domain.attendance.facade;

import com.young.bbabbico.domain.attendance.domain.Attendance;
import com.young.bbabbico.domain.attendance.domain.repository.AttendanceRepository;
import com.young.bbabbico.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class AttendanceFacade {

    private final AttendanceRepository attendanceRepository;

    @Transactional(readOnly = true)
    public Attendance getTodayAttendanceByUser(User user) {
        return attendanceRepository.findByUserAndCreatedAtGreaterThan(
                user, LocalDateTime.of(LocalDate.now(), LocalTime.MIN))
                .orElseThrow(() -> new IllegalArgumentException("출근하지 않은 사용자입니다."));
    }
}
