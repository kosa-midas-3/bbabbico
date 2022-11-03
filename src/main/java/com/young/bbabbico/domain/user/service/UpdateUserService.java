package com.young.bbabbico.domain.user.service;

import com.young.bbabbico.domain.department.facade.DepartmentFacade;
import com.young.bbabbico.domain.user.domain.User;
import com.young.bbabbico.domain.user.domain.type.Authority;
import com.young.bbabbico.domain.user.facade.UserFacade;
import com.young.bbabbico.domain.user.presentation.dto.request.UpdateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateUserService {

    private final UserFacade userFacade;
    private final DepartmentFacade departmentFacade;

    @Transactional
    public void execute(String name, UpdateUserRequest request) {
        User user = userFacade.getUserByName(name);
        userFacade.checkAuthority(user.getAuthority(), Authority.ADMIN);

        User targetUser = userFacade.getUserByName(request.getTargetName());
        targetUser.updateUser(request.getName(), request.getNickname(),
                departmentFacade.getDepartmentByName(request.getDepartment()));
    }
}
