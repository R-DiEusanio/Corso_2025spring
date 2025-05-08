package com.example.demo.service;
import com.example.demo.entity.Corsi;
import com.example.demo.entity.Docente;
import com.example.demo.repository.CorsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CorsiService {

    @Autowired
    CorsiRepository corsiRepository;

    public List<Corsi> findAll() {
        return corsiRepository.findAll();
    }

    public Corsi get(Long id) {
        return corsiRepository.findById(id).orElseThrow();
    }

    public Corsi save(Corsi c) {
        return corsiRepository.save(c);

    }

    public void delete(Long id) {
        corsiRepository.deleteById(id);

    }

    public List<Corsi> CorsiOrdinatiIdDocente() {
        return corsiRepository.CorsiOrdinatiIdDocenti();
    }


}
