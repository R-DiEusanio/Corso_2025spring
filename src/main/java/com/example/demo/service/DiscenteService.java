package com.example.demo.service;
import com.example.demo.entity.Discente;
import com.example.demo.repository.DiscenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DiscenteService {

    @Autowired
    DiscenteRepository discenteRepository;

    public List<Discente> findAll() {
        return discenteRepository.findAll();
    }

    public Discente get(Long id) {
        return discenteRepository.findById(id).orElseThrow();
    }

    public Discente save(Discente s) {
        return discenteRepository.save(s);
    }

    public void delete(long id) {
        discenteRepository.deleteById(id);
    }

    public List<Discente> maggiorenni() {
        return discenteRepository.trovaTuttiMaggiorenni(30);
    }

    public List<Discente> residenza(String citta) {
        return discenteRepository.trovaResidenza(citta);

    }

    public List<Discente> DiscentiOrdinatiPerNome() {
        return discenteRepository.DiscentiOrdinatiPerNome();
    }

    public Optional<Discente> findByCompleto(String nomeCompleto) {
        return discenteRepository.findByNomeCompleto(nomeCompleto);
    }


    public List<Discente> findByCorsoId(Long corsoId) {
        return discenteRepository.findDiscentiByCorsoId(corsoId);

    }

}




