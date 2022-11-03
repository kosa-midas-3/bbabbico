package com.young.bbabbico.domain.home.presentation.dto.reqeust;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RespondHomeApplyRequest {

    @NotNull
    private Boolean accept;

    @NotNull
    private Long homeApplyId;
}
