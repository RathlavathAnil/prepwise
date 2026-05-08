package com.anil.placementprep.service;

import com.anil.placementprep.entity.Progress;
import com.anil.placementprep.repository.ProgressRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProgressService {

    private final ProgressRepository progressRepository;

    public Progress saveProgress(Progress progress) {
        return progressRepository.save(progress);
    }

    public List<Progress> getUserProgress(Long userId) {
        return progressRepository.findByUserId(userId);
    }

    public Progress updateProgress(Long id, Progress updatedProgress) {

        Progress progress = progressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Progress not found"));

        progress.setStatus(updatedProgress.getStatus());

        return progressRepository.save(progress);
    }
}