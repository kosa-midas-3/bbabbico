package com.young.bbabbico.domain.user.service;

import com.young.bbabbico.domain.department.domain.Department;
import com.young.bbabbico.domain.department.facade.DepartmentFacade;
import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.domain.repository.UserRepository;
import com.young.bbabbico.domain.user.domain.type.Authority;
import com.young.bbabbico.domain.user.presentation.dto.request.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JoinUserService {

    private final UserRepository userRepository;
    private final DepartmentFacade departmentFacade;

    @Transactional
    public void execute(CreateUserRequest request) {
        Department department = departmentFacade.getDepartmentByName(request.getDepartment());

        userRepository.save(User.builder()
                .nickname(request.getNickname())
                .name(request.getName())
                .authority(myAuthority(request.getName()))
                .department(department)
                .build()
        );
    }

    private Authority myAuthority(String name) {
        if (name.startsWith("admin")) {
            return Authority.ADMIN;
        } else if (name.startsWith("user")) {
            return Authority.USER;
        } else {
            throw new IllegalArgumentException("name 은 user 또는 admin 으로 시작해야 합니다.");
        }
    }
}
