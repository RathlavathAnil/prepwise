package com.anil.placementprep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "PrepWise Backend Running";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
