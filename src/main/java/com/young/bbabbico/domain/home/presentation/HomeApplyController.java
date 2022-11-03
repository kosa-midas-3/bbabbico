package com.young.bbabbico.domain.home.presentation;

import com.young.bbabbico.domain.home.presentation.dto.reqeust.RespondHomeApplyRequest;
import com.young.bbabbico.domain.home.presentation.dto.response.HomeApplyListResponse;
import com.young.bbabbico.domain.home.service.ApplyWorkingFromHomeService;
import com.young.bbabbico.domain.home.service.QueryHomeAppliesService;
import com.young.bbabbico.domain.home.service.RespondHomeApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeApplyController {

    private final QueryHomeAppliesService queryHomeAppliesService;
    private final ApplyWorkingFromHomeService applyWorkingFromHomeService;
    private final RespondHomeApplyService respondHomeApplyService;

    @GetMapping("/apply")
    public HomeApplyListResponse queryHomeApplies() {
        return queryHomeAppliesService.execute();
    }

    @PostMapping("/apply")
    public void applyWorkingFromHome(@RequestParam String name) {
        applyWorkingFromHomeService.execute(name);
    }

    @PutMapping("/apply")
    public void respondHomeApply(@RequestParam String name, @RequestBody @Valid RespondHomeApplyRequest request) {
        respondHomeApplyService.execute(name, request);
    }
}
