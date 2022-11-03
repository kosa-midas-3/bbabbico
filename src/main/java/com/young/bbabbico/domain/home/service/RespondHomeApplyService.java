package com.young.bbabbico.domain.home.service;

import com.young.bbabbico.domain.home.domain.repository.HomeApplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RespondHomeApplyService {

    private final HomeApplyRepository homeApplyRepository;

    @Transactional
    public void execute(String name) {

    }
}
