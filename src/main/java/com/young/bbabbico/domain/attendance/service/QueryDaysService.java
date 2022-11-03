package com.young.bbabbico.domain.attendance.service;

import com.young.bbabbico.domain.attendance.domain.Attendance;
import com.young.bbabbico.domain.attendance.domain.repository.AttendanceRepository;
import com.young.bbabbico.domain.attendance.presentation.dto.response.AttendanceListResponse;
import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryDaysService {

    private final UserFacade userFacade;
    private final AttendanceRepository attendanceRepository;

    public AttendanceListResponse execute(String name, LocalDate month) {
        return AttendanceListResponse.builder()
                .days(createDays(name, month))
                .build();
    }

    private List<Long> createDays(String name, LocalDate month) {
        User user = userFacade.getUserByName(name);
        List<Attendance> attendanceList = attendanceRepository
                .findByUserAndDateGreaterThanEqualAndDateLessThanEqual(user, month.withDayOfMonth(1),
                        month.withDayOfMonth(month.lengthOfMonth()));

        Long[] days = new Long[32];
        attendanceList.forEach(a -> {
            days[a.getDate().getDayOfMonth()] = a.getWorkingTime();
        });

        return Arrays.asList(days);
    }
}
