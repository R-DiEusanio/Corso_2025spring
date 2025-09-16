package com.example.demo.controller;


import com.example.demo.data.dto.AuthRequestDTO;
import com.example.demo.data.dto.AuthResponseDTO;
import com.example.demo.entity.Utente;
import com.example.demo.service.AuthService;
import com.example.demo.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    public AuthRestController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO request, HttpServletResponse response) {
        AuthResponseDTO authResponse = authService.login(request);

        ResponseCookie cookie = ResponseCookie.from("jwt", authResponse.getToken())
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(24 * 60 * 60)
                .sameSite("Strict")
                .build();

        response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequestDTO request, HttpServletResponse response) {
        AuthResponseDTO authResponse = authService.register(request);

        ResponseCookie cookie = ResponseCookie.from("jwt", authResponse.getToken())
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(24 * 60 * 60)
                .sameSite("Strict")
                .build();

        response.setHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return ResponseEntity.ok(authResponse);
    }
}
