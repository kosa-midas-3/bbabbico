package com.young.bbabbico.domain.user.service;

import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.domain.repository.UserRepository;
import com.young.bbabbico.domain.user.presentation.dto.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JoinUserService {

    private final UserRepository userRepository;

    @Transactional
    public void execute(CreateUserRequest request) {
        userRepository.save(User.builder()
                .nickname(request.getNickname())
                .name(request.getName())
                .department(request.getDepartment())
                .build()
        );
    }
}
