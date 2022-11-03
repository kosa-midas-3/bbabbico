package com.young.bbabbico.domain.coretime.service;

import com.young.bbabbico.domain.coretime.domain.CoreTime;
import com.young.bbabbico.domain.coretime.domain.repository.CoreTimeRepository;
import com.young.bbabbico.domain.coretime.presentation.dto.request.CreateCoreTimeRequest;
import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.domain.type.Authority;
import com.young.bbabbico.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateCoreTimeService {

    private final UserFacade userFacade;
    private final CoreTimeRepository coreTimeRepository;

    @Transactional
    public void execute(String name, CreateCoreTimeRequest request) {
        User user = userFacade.getUserByName(name);
        userFacade.checkAuthority(user.getAuthority(), Authority.ADMIN);

        coreTimeRepository.saveAll(
                request.getUserList()
                        .stream()
                        .map(u -> createCoreTime(u, request))
                        .collect(Collectors.toList())
        );
    }

    private CoreTime createCoreTime(String name, CreateCoreTimeRequest request) {
        User user = userFacade.getUserByName(name);

        return CoreTime.builder()
                .startTime(request.getTimeList().get(0))
                .endTime(request.getTimeList().get(1))
                .reason(request.getReason())
                .user(user)
                .build();
    }
}
