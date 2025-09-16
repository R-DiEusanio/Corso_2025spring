package com.example.demo.data.dto;

public class UtenteDTO {
    private Long id;
    private String email;
    private String ruolo;

    public UtenteDTO() {}

    public UtenteDTO(Long id, String email, String ruolo) {
        this.id = id;
        this.email = email;
        this.ruolo = ruolo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRuolo() { return ruolo; }
    public void setRuolo(String ruolo) { this.ruolo = ruolo; }
}
