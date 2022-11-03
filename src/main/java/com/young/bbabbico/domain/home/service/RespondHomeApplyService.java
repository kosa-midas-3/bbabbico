package com.young.bbabbico.domain.home.service;

import com.young.bbabbico.domain.home.domain.HomeApply;
import com.young.bbabbico.domain.home.domain.repository.HomeApplyRepository;
import com.young.bbabbico.domain.home.domain.type.HomeApplyStatus;
import com.young.bbabbico.domain.home.facade.HomeApplyFacade;
import com.young.bbabbico.domain.home.presentation.dto.reqeust.RespondHomeApplyRequest;
import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.domain.type.Authority;
import com.young.bbabbico.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class RespondHomeApplyService {

    private final UserFacade userFacade;
    private final HomeApplyFacade homeApplyFacade;

    @Transactional
    public void execute(String name, RespondHomeApplyRequest request) {
        User user = userFacade.getUserByName(name);
        userFacade.checkAuthority(user.getAuthority(), Authority.ADMIN);

        HomeApply homeApply = homeApplyFacade.getHomeApplyById(request.getHomeApplyId());
        homeApply.respondHomeApply(request.getAccept() ? HomeApplyStatus.ACCEPTED : HomeApplyStatus.REFUSED);
    }
}
