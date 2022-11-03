package com.young.bbabbico.domain.user.presentation;

import com.young.bbabbico.domain.user.presentation.dto.request.CreateUserRequest;
import com.young.bbabbico.domain.user.service.JoinUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final JoinUserService joinUserService;

    @PostMapping
    public void joinUser(@RequestBody @Valid CreateUserRequest request) {
        joinUserService.execute(request);
    }
}
