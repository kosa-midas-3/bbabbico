package com.young.bbabbico.domain.coretime.presentation;

import com.young.bbabbico.domain.coretime.presentation.dto.request.CreateCoreTimeRequest;
import com.young.bbabbico.domain.coretime.service.CreateCoreTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/core-time")
@RequiredArgsConstructor
public class CoreTimeController {

    private final CreateCoreTimeService createCoreTimeService;

    @PostMapping
    public void createCoreTime(@RequestParam String name, @RequestBody @Valid CreateCoreTimeRequest request) {
        createCoreTimeService.execute(name, request);
    }
}