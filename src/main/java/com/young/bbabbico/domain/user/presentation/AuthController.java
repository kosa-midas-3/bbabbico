package com.young.bbabbico.domain.user.presentation;

import com.young.bbabbico.domain.user.presentation.dto.response.UserResponse;
import com.young.bbabbico.domain.user.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginUserService loginUserService;

    @PostMapping
    public UserResponse loginUser(@RequestParam String name) {
        return loginUserService.execute(name);
    }
}
