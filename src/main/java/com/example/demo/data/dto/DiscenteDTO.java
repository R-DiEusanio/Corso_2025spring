package com.example.demo.data.dto;

import java.util.List;

public class DiscenteDTO {


    private String nome;
    private String cognome;
    private String matricola;
    private Integer eta;
    private String cittaResidenza;
    private List<String> corsi;

    public DiscenteDTO() {
    }

    public DiscenteDTO(String nome, String cognome, String matricola, Integer eta, String cittaResidenza, List<String> corsi) {

        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.eta = eta;
        this.cittaResidenza = cittaResidenza;
        this.corsi = corsi;

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

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getCittaResidenza() {
        return cittaResidenza;
    }

    public void setCittaResidenza(String cittaResidenza) {
        this.cittaResidenza = cittaResidenza;
    }

    public List<String> getCorsi() {
        return corsi;
    }

    public void setCorsi(List<String> corsi) {
        this.corsi = corsi;
    }
}
