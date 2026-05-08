package com.anil.placementprep.controller;

import com.anil.placementprep.dto.RegisterRequest;
import com.anil.placementprep.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")

    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }
}