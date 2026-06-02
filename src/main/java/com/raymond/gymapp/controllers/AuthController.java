package com.raymond.gymapp.controllers;

import com.raymond.gymapp.dto.AuthRequest;
import com.raymond.gymapp.model.User;
import com.raymond.gymapp.security.JwtUtil;
import com.raymond.gymapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest authRequest) {
        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setPasswordHash(passwordEncoder.encode(authRequest.getPassword()));
        userService.createUser(user);

        return ResponseEntity.ok("User registered successfully");


    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        User user = userService.findByUsername(authRequest.getUsername());

        if (user == null || !passwordEncoder.matches(authRequest.getPassword(), user.getPasswordHash())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        String token = jwtUtil.generateToken(user.getUsername());
        return ResponseEntity.ok(token);
    }
}
