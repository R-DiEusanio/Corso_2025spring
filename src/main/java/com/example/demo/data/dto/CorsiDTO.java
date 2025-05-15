package com.example.demo.data.dto;

import java.util.List;

public class CorsiDTO {
    private Long id;
    private String nomeCorso;
    private Integer annoAccademico;

    private String docenteNome;
    private List<String> discentiNomi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCorso() {
        return nomeCorso;
    }

    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }

    public Integer getAnnoAccademico() {
        return annoAccademico;
    }

    public void setAnnoAccademico(Integer annoAccademico) {
        this.annoAccademico = annoAccademico;
    }

    public String getDocenteNome() {
        return docenteNome;
    }

    public void setDocenteNome(String docenteNome) {
        this.docenteNome = docenteNome;
    }

    public List<String> getDiscentiNomi() {
        return discentiNomi;
    }

    public void setDiscentiNomi(List<String> discentiNomi) {
        this.discentiNomi = discentiNomi;
    }
}
