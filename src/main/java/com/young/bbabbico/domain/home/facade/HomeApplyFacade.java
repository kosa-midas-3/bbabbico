package com.young.bbabbico.domain.home.facade;

import com.young.bbabbico.domain.home.domain.HomeApply;
import com.young.bbabbico.domain.home.domain.repository.HomeApplyRepository;
import com.young.bbabbico.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class HomeApplyFacade {

    private final HomeApplyRepository homeApplyRepository;

    @Transactional(readOnly = true)
    public HomeApply getHomeApplyById(Long id) {
        return homeApplyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 신청이 존재하지 않습니다."));
    }

    @Transactional(readOnly = true)
    public HomeApply getNullableHomeApplyByUser(User user) {
        return homeApplyRepository.findByUserAndDate(user, LocalDate.now());
    }
}
