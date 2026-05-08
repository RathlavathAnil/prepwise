package com.anil.placementprep.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DashboardResponse {

    private long totalQuestions;

    private long solvedQuestions;

    private long revisionQuestions;

    private long unsolvedQuestions;
}