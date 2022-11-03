package com.young.bbabbico.domain.user.service;

import com.young.bbabbico.domain.attendance.domain.repository.AttendanceRepository;
import com.young.bbabbico.domain.attendance.facade.AttendanceFacade;
import com.young.bbabbico.domain.coretime.domain.repository.CoreTimeRepository;
import com.young.bbabbico.domain.home.domain.repository.HomeApplyRepository;
import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.domain.repository.UserRepository;
import com.young.bbabbico.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteUserService {

    private final UserFacade userFacade;
    private final AttendanceRepository attendanceRepository;
    private final HomeApplyRepository homeApplyRepository;
    private final CoreTimeRepository coreTimeRepository;
    private final UserRepository userRepository;

    @Transactional
    public void execute(String name) {
        User user = userFacade.getUserByName(name);
        attendanceRepository.deleteAllByUser(user);
        homeApplyRepository.deleteAllByUser(user);
        coreTimeRepository.deleteAllByUser(user);
        userRepository.delete(user);
    }
}
