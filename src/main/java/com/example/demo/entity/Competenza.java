package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "competenze")
public class Competenza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String livello;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    public Competenza() {}

    public Competenza(String nome, String livello, Docente docente) {
        this.nome = nome;
        this.livello = livello;
        this.docente = docente;
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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
