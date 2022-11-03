package com.young.bbabbico.domain.home.presentation;

import com.young.bbabbico.domain.home.service.ApplyWorkingFromHomeService;
import com.young.bbabbico.domain.home.service.RespondHomeApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeApplyController {

    private final ApplyWorkingFromHomeService applyWorkingFromHomeService;
    private final RespondHomeApplyService respondHomeApplyService;

    @PostMapping("/apply")
    public void applyWorkingFromHome(@RequestParam String name) {
        applyWorkingFromHomeService.execute(name);
    }

    @DeleteMapping("/apply")
    public void respondHomeApply(@RequestParam String name) {
        respondHomeApplyService.execute(name);
    }
}
