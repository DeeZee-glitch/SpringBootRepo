package com.example.DemoZain.controller.auth;

import com.example.DemoZain.dto.auth.LoginRequest;
import com.example.DemoZain.util.jwt.JwtUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final JwtUtil jwtUtil;

    public AuthenticationController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Validate username and password (replace with real authentication logic)
        if ("user".equals(loginRequest.getUsername()) && "userpass".equals(loginRequest.getPassword())) {
            List<String> roles = List.of("USER");  // Or fetch from the database
            return jwtUtil.generateToken(loginRequest.getUsername(), roles);  // Pass roles
        }
        throw new RuntimeException("Invalid credentials");
    }
}
