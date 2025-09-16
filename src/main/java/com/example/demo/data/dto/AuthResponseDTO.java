package com.example.demo.data.dto;

public class AuthResponseDTO {

    private String token;
    private UtenteDTO utente;

    public AuthResponseDTO() {}

    public AuthResponseDTO(String token, UtenteDTO utente) {
        this.token = token;
        this.utente = utente;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UtenteDTO getUtente() {
        return utente;
    }

    public void setUtente(UtenteDTO utente) {
        this.utente = utente;
    }
}
