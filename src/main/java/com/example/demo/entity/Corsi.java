package com.example.demo.entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "studenti_corsi",
            joinColumns = @JoinColumn(name = "id_corso"),
            inverseJoinColumns = @JoinColumn(name = "id_studenti")
    )
    private List<Discente> discenti = new ArrayList<>();

    public Corsi() {}

    public Corsi(String nomeCorso,Integer annoAccademico,List<Discente> discenti) {

        this.nomeCorso = nomeCorso;
        this.annoAccademico= annoAccademico;
        this.discenti = discenti;
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

    public List<Discente> getDiscenti() {
        return discenti;
    }

    public void setDiscenti(List<Discente> discenti) {
        this.discenti = discenti;
    }
}
