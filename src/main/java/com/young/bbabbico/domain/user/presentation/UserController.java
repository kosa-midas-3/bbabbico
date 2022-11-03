package com.young.bbabbico.domain.user.presentation;

import com.young.bbabbico.domain.user.presentation.dto.request.CreateUserRequest;
import com.young.bbabbico.domain.user.presentation.dto.request.UpdateUserRequest;
import com.young.bbabbico.domain.user.service.DeleteUserService;
import com.young.bbabbico.domain.user.service.JoinUserService;
import com.young.bbabbico.domain.user.service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final JoinUserService joinUserService;
    private final UpdateUserService updateUserService;
    private final DeleteUserService deleteUserService;

    @PostMapping
    public void joinUser(@RequestBody @Valid CreateUserRequest request) {
        joinUserService.execute(request);
    }

    @PutMapping
    public void updateUser(@RequestParam String name, @RequestBody @Valid UpdateUserRequest request) {
        updateUserService.execute(name, request);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam String name) {
        deleteUserService.execute(name);
    }
}
