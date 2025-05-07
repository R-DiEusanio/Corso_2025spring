package com.example.demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "corsi")
public class Corsi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_corso", nullable = false)
    private String nomeCorso;

    @ManyToOne
    @JoinColumn(name = "id_doc")
    private Docente docente;

    @Column(name = "anno_accademico", nullable = false)
    private Integer annoAccademico;

    public Corsi() {}

    public Corsi(String nomeCorso,Integer annoAccademico) {

        this.nomeCorso = nomeCorso;
        this.annoAccademico= annoAccademico;
    }

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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Integer getAnnoAccademico() {
        return annoAccademico;
    }

    public void setAnnoAccademico(Integer annoAccademico) {
        this.annoAccademico = annoAccademico;
    }
}
