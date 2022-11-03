package com.young.bbabbico.domain.coretime.facade;

import com.young.bbabbico.domain.coretime.domain.CoreTime;
import com.young.bbabbico.domain.coretime.domain.repository.CoreTimeRepository;
import com.young.bbabbico.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CoreTimeFacade {

    private final CoreTimeRepository coreTimeRepository;

    public CoreTime getTodayNullableCoreTimeByUser(User user) {
        return coreTimeRepository.findCoreTimeByUserAndDate(user, LocalDate.now());
    }
}
