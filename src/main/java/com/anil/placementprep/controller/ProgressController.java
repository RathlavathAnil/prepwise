package com.anil.placementprep.controller;

import com.anil.placementprep.entity.Progress;
import com.anil.placementprep.service.ProgressService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
@RequiredArgsConstructor

public class ProgressController {

    private final ProgressService progressService;

    @PostMapping("/save")
    public Progress saveProgress(@RequestBody Progress progress) {
        return progressService.saveProgress(progress);
    }

    @GetMapping("/user/{userId}")
    public List<Progress> getUserProgress(@PathVariable Long userId) {
        return progressService.getUserProgress(userId);
    }

    @PutMapping("/update/{id}")
    public Progress updateProgress(
            @PathVariable Long id,
            @RequestBody Progress progress
    ) {
        return progressService.updateProgress(id, progress);
    }
}