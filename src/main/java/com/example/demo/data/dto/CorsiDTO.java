package com.example.demo.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class CorsiDTO {

    @JsonIgnore
    private Long id;
    private String nomeCorso;
    private Integer annoAccademico;

    @JsonIgnore
    private Long docenteId;
    private String docenteNome;

    @JsonIgnore
    private List<Long> discenteId;
    private List<String> discentiNomi;

public CorsiDTO() {}

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

    public Long getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }

    public String getDocenteNome() {
        return docenteNome;
    }

    public void setDocenteNome(String docenteNome) {
        this.docenteNome = docenteNome;
    }

    public List<Long> getDiscenteId() {
        return discenteId;
    }

    public void setDiscenteId(List<Long> discenteId) {
        this.discenteId = discenteId;
    }

    public List<String> getDiscentiNomi() {
        return discentiNomi;
    }

    public void setDiscentiNomi(List<String> discentiNomi) {
        this.discentiNomi = discentiNomi;
    }
}
