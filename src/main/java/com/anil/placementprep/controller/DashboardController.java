package com.anil.placementprep.controller;

import com.anil.placementprep.dto.DashboardResponse;
import com.anil.placementprep.service.DashboardService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor

public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/stats")
    public DashboardResponse getStats() {
        return dashboardService.getDashboardStats();
    }
}