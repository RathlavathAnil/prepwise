package com.anil.placementprep.service;

import com.anil.placementprep.dto.DashboardResponse;
import com.anil.placementprep.repository.ProgressRepository;
import com.anil.placementprep.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DashboardService {

    private final QuestionRepository questionRepository;
    private final ProgressRepository progressRepository;

    public DashboardResponse getDashboardStats() {

        long totalQuestions = questionRepository.count();

        long solved = progressRepository.countByStatus("SOLVED");

        long revision = progressRepository.countByStatus("REVISION");

        long unsolved =
                totalQuestions - solved - revision;

        return DashboardResponse.builder()
                .totalQuestions(totalQuestions)
                .solvedQuestions(solved)
                .revisionQuestions(revision)
                .unsolvedQuestions(unsolved)
                .build();
    }
}