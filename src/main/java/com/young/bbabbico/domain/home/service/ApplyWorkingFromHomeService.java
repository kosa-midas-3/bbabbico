package com.young.bbabbico.domain.home.service;

import com.young.bbabbico.domain.home.domain.HomeApply;
import com.young.bbabbico.domain.home.domain.repository.HomeApplyRepository;
import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApplyWorkingFromHomeService {

    private final UserFacade userFacade;
    private final HomeApplyRepository homeApplyRepository;

    @Transactional
    public void execute(String name) {
        User user = userFacade.getUserByName(name);

        homeApplyRepository.save(
                HomeApply.builder()
                        .user(user)
                        .build()
        );
    }
}
