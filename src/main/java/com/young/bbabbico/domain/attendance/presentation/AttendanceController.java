package com.young.bbabbico.domain.attendance.presentation;

import com.young.bbabbico.domain.attendance.service.GoToWorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final GoToWorkService goToWorkService;

    @PostMapping
    public void goToWork(@RequestParam String name) {
        goToWorkService.execute(name);
    }
}
