package com.young.bbabbico.domain.user.service;

import com.young.bbabbico.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteUserService {

    private final UserRepository userRepository;

    @Transactional
    public void execute(String name) {
        userRepository.deleteByName(name);
    }
}
