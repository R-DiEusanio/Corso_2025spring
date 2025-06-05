package com.example.demo.service;

import com.example.demo.entity.Docente;
import com.example.demo.repository.DocenteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    public Docente get(Long id) {
        return docenteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Docente non trovato con id: " + id
                ));
    }

    public Docente save(Docente d) {
        return docenteRepository.save(d);
    }

    public void delete(Long id) {
        docenteRepository.deleteById(id);
    }

    public List<Docente> cercaNome(String nome) {
        return docenteRepository.trovaPerNome(nome);
    }

    public Optional<Docente> findByNomeCompleto(String nomeCompleto) {
        return docenteRepository.findByNomeCompleto(nomeCompleto);
    }

    public List<Docente> findByNomeAndCognome(String nome, String cognome) {
        return docenteRepository.findByNomeAndCognome(nome, cognome);
    }

}