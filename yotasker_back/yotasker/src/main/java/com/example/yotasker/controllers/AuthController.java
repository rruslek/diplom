package com.example.yotasker.controllers;

import com.example.yotasker.dto.AuthRequest;
import com.example.yotasker.dto.AuthResponse;
import com.example.yotasker.service.AuthService;
import com.example.yotasker.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@CrossOrigin(origins="http://localhost:3000/", allowCredentials = "true")
public class AuthController {
    @Autowired
    private UsersService usersService;

    private final AuthService service;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }
}