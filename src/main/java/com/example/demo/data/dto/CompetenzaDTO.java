package com.example.demo.data.dto;

public class CompetenzaDTO {

    private Long id;
    private String nome;
    private String livello;
    private Long docenteId;

    public CompetenzaDTO() {
    }

    public CompetenzaDTO(Long id, String nome, String livello, Long docenteId) {
        this.id = id;
        this.nome = nome;
        this.livello = livello;
        this.docenteId = docenteId;
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

    public String getLivello() {
        return livello;
    }

    public void setLivello(String livello) {
        this.livello = livello;
    }

    public Long getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }
}
