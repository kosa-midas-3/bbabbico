package com.young.bbabbico.domain.home.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@Builder
public class HomeApplyListResponse {

    private Map<String, List<HomeApplyResponse>> homeApplies;
}
