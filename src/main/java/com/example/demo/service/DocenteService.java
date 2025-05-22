package com.example.demo.service;

import com.example.demo.entity.Docente;
import com.example.demo.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteService {

    @Autowired
    DocenteRepository docenteRepository;

    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    public Docente get(Long id) {
        return docenteRepository.findById(id).orElseThrow();
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

}