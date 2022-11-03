package com.young.bbabbico.domain.user.presentation;

import com.young.bbabbico.domain.user.presentation.dto.request.CreateUserRequest;
import com.young.bbabbico.domain.user.service.DeleteUserService;
import com.young.bbabbico.domain.user.service.JoinUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final JoinUserService joinUserService;
    private final DeleteUserService deleteUserService;

    @PostMapping
    public void joinUser(@RequestBody @Valid CreateUserRequest request) {
        joinUserService.execute(request);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam String name) {
        deleteUserService.execute(name);
    }
}
