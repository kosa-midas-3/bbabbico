package com.young.bbabbico.domain.attendance.service;

import com.young.bbabbico.domain.attendance.domain.Attendance;
import com.young.bbabbico.domain.attendance.domain.repository.AttendanceRepository;
import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GoToWorkService {

    private final AttendanceRepository attendanceRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(String name) {
        User user = userFacade.getUserByName(name);
        attendanceRepository.save(Attendance.builder()
                .user(user)
                .build()
        );
    }
}
