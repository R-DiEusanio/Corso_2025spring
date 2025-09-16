package com.example.demo.service;

import com.example.demo.data.dto.AuthRequestDTO;
import com.example.demo.data.dto.AuthResponseDTO;
import com.example.demo.entity.Utente;
import com.example.demo.mapper.UtenteMapper;
import com.example.demo.repository.UtenteRepository;
import com.example.demo.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {


    private UtenteRepository utenteRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(UtenteRepository utenteRepository, JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
        this.utenteRepository = utenteRepository;
    }

    public AuthResponseDTO register(AuthRequestDTO request) {
        if (utenteRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Utente già esistente");
        }

        Utente utente = new Utente();
        utente.setEmail(request.getEmail());
        utente.setPassword(passwordEncoder.encode(request.getPassword()));
        utente.setRuolo("Admin");

        utenteRepository.save(utente);

        String token = jwtUtil.generateToken(request.getEmail());
        return new AuthResponseDTO(token, UtenteMapper.toDto(utente));

    }

    public AuthResponseDTO login(AuthRequestDTO request) {
        Optional<Utente> utente = Optional.ofNullable(utenteRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Utente non trovato")));
        if (!passwordEncoder.matches(request.getPassword(), utente.get().getPassword())) {
            throw new RuntimeException("Password errata");
        }
        String token = jwtUtil.generateToken(utente.get().getEmail());
        return new AuthResponseDTO(token, UtenteMapper.toDto(utente.get()));
    }
}
