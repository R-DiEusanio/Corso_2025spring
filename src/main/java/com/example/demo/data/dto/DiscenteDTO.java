package com.example.demo.data.dto;

import java.util.List;

public class DiscenteDTO {

    private Long id;
    private String nome;
    private String cognome;
    private List<CorsiDTO> corsi;

    public DiscenteDTO() {
    }

    public DiscenteDTO(Long id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }

    public DiscenteDTO(Long id, String nome, String cognome, List<CorsiDTO> corsi) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.corsi = corsi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public List<CorsiDTO> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<CorsiDTO> corsi) {
        this.corsi = corsi;
    }
}
