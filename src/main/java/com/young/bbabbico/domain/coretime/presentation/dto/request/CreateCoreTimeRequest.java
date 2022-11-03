package com.young.bbabbico.domain.coretime.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCoreTimeRequest {

    @NotNull
    private List<String> userList;

    @NotNull
    private List<LocalTime> timeList;

    @NotBlank
    @Max(100)
    private String reason;
}
