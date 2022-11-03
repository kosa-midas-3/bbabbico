package com.young.bbabbico.domain.user.facade;

import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.domain.repository.UserRepository;
import com.young.bbabbico.domain.user.domain.type.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User getUserByName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("유저가 없습니다."));
    }

    @Transactional(readOnly = true)
    public void checkAuthority(Authority actual, Authority expected) {
        if (actual != expected) {
            throw new IllegalArgumentException("권한이 없습니다.");
        }
    }
}
